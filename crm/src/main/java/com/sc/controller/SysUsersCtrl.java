package com.sc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.entity.SysUsers;
import com.sc.service.SysUsersRoleService;
import com.sc.service.SysUsersService;

@Controller
@RequestMapping("/SysUsersCtrl")
public class SysUsersCtrl {
	
	@Autowired
	SysUsersService sysUsersService;
	@Autowired
	SysUsersRoleService sysUsersRoleService;
	
//	@RequestMapping("/goupdate.do")
//	public ModelAndView goupdate(ModelAndView mav,SysUsers user){
//		System.out.println("��ת���޸�ҳ�棡"+user);
//		
//		SysUsers users = this.sysUsersService.get(user.getUsersId());
//		mav.addObject("user", user);
//		mav.setViewName("usersupdate");
//		return mav;
//	}
	@RequestMapping("/listPage.do")
	public ModelAndView listPage(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="7")Integer pageSize){
		
		mav.addObject("p", sysUsersService.select(pageNum, pageSize));
		mav.setViewName("ssf/userslistpage");
		System.out.println(sysUsersService.select(pageNum, pageSize));
		System.out.println("��ҳ");
		
		return mav;
	}
	@RequestMapping("/update.do")
	public ModelAndView update(ModelAndView mav,
			HttpServletRequest req,
			SysUsers u) throws IllegalStateException, IOException{
	
		this.sysUsersService.update(u);
		mav.setViewName("redirect:list.do");//�ض���list����
		return mav;
	}

	@RequestMapping("/userList.do")
	public ModelAndView userList(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="2")Integer pageSize,SysUsers users,String isdel,
			String isall,HttpServletRequest req){
		System.out.println("�Ƿ�"+isall);
		System.out.println(users.getUsersId());
		System.out.println(users.getUsersName());
		HttpSession session = req.getSession();
		if(users.getUsersName()!=null||users.getSysUserinfo()!=null){
			session.setAttribute("seluser", users);
		}
		if(isall!=null&&isall.equals("yes?v=4.0")){
			users.setUsersName(null);
			users.setSysUserinfo(null);
			session.setAttribute("seluser", users);
		}
		
		PageInfo<SysUsers> info = this.sysUsersService.selectUserinfo2(pageNum, pageSize,(SysUsers)session.getAttribute("seluser") );
		if(isdel!=null){
			mav.addObject("isdel", "yes");
		}
		mav.addObject("u", info);
		mav.setViewName("wangyi/userlist");
		return mav;
	}
	
	@RequestMapping("/deleteUser.do")
	public ModelAndView deleteUser(ModelAndView mav,SysUsers user,Long[] delid){
		System.out.println("Ҫɾ�����û�idΪ"+user.getUsersId());
		this.sysUsersService.deleteUser(user);
		this.sysUsersRoleService.deleteByuId(user.getUsersId());
		if(delid!=null&&delid.length>0){
			for (Long long1 : delid) {
				user.setUsersId(long1);
				System.out.println(long1);
				System.out.println("Ҫɾ�����û�idΪ"+user.getUsersId());
				this.sysUsersService.deleteUser(user);
				this.sysUsersRoleService.deleteByuId(user.getUsersId());
			}
		}
		mav.setViewName("redirect:userList.do?isdel=yes");
		return mav;
	}
	
	@RequestMapping("/printExcel.do")
	public void printExcel(Long[] print,HttpServletResponse resp) throws IOException{
		
		//��ͷ����
		String[] header={"�û�id","�û��˺�","�û�����","�û�״̬","������ʱ��"};
		
		//����һ��������
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		//����һ�����
		HSSFSheet sheet = workbook.createSheet("�û���Ϣ��");
		
		//���ñ���п�
		sheet.setDefaultColumnWidth(10);
		
		//������һ�б�ͷ
		HSSFRow headRow = sheet.createRow(0);
		
		//������һ�б�ͷ
		for (int i = 0; i < header.length; i++) {
			//����һ����Ԫ��
			HSSFCell cell = headRow.createCell(i);
			//����һ�����ݶ���
			HSSFRichTextString textString = new HSSFRichTextString(header[i]);
			//�����ݶ�����뵥Ԫ��
			cell.setCellValue(textString);
		}
		//����ÿһ���û���Ϣ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < print.length; i++) {
			HSSFRow row = sheet.createRow(i+1);
			SysUsers sysUsers = this.sysUsersService.selectUserinfo(print[i]);
			for(int j=0;j<5;j++){
				HSSFCell cell = row.createCell(j);
				if(j==0){
					cell.setCellValue(sysUsers.getUsersId());
				}else if(j==1){
					cell.setCellValue(sysUsers.getUsersName());
				}else if(j==2){
					cell.setCellValue(sysUsers.getSysUserinfo().getEmpName());
				}else if(j==3){
					if(sysUsers.getUsersState().equals("0")){
						cell.setCellValue("����");
					}else{
						cell.setCellValue("����");
					}
				}else{
					String format = sdf.format(sysUsers.getChangeDate());
					cell.setCellValue(format);
				}
			}
		}
		
		//׼����Excel�������ͨ��response�����ҳ������
        //�˽��������
		resp.setContentType("application/octet-stream");
		  //�����������õ���Excel�����ƣ���������Ϊstudent.xls
		resp.setHeader("Content-disposition", "attachment;filename=users.xls");
		//ˢ�»���
        resp.flushBuffer();
        //workbook��Excelд�뵽response��������У���ҳ������
        workbook.write(resp.getOutputStream());
	}
}
