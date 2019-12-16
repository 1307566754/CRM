package com.sc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.SysUserinfo;
import com.sc.service.SysUsersInfoService;

@Controller
@RequestMapping("/SysUsersInfoCtrl")
public class SysUserInfoCtroller {
	@Autowired
	SysUsersInfoService sysUsersInfoService;

	
	
	@RequestMapping("/listPage.do")
	public ModelAndView listPage(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="12")Integer pageSize){
		
		mav.addObject("p", sysUsersInfoService.select(pageNum, pageSize));
		mav.setViewName("ssf/userinfopage");
		System.out.println(sysUsersInfoService.select(pageNum, pageSize));
		
		System.out.println("��ҳ");
		
		return mav;
	}
	@RequestMapping("/goupdate.do")
	public ModelAndView goupdate(ModelAndView mav,SysUserinfo u){
		System.out.println("��ת���޸�ҳ�棡"+u);
		SysUserinfo users = this.sysUsersInfoService.get(u.getEmpId());
		mav.addObject("u", users);
		mav.setViewName("usersupdate");
		return mav;
	}
	@RequestMapping("/update.do")
	public ModelAndView update(ModelAndView mav,
			MultipartFile upload,
			HttpServletRequest req,
			SysUserinfo u) throws IllegalStateException, IOException{
		System.out.println("��ʼ�ϴ��ļ�"+u);
		
		//����û�ѡ���ļ�����ôִ���ϴ�����
		if(upload!=null){
			String filename=upload.getOriginalFilename();//�ļ���
			if(filename!=null&&!filename.equals("")){
				//��ȡupload�ļ�������·��
				String path=req.getSession().
						getServletContext().getRealPath("upload");
				//���磺26456456435.jpg
				filename=System.currentTimeMillis()
						+filename.substring(filename.lastIndexOf("."));
				//Ŀ�ĵ��ļ�����
				File file=new File(path+"/"+filename);
				upload.transferTo(file);//ת���洢�ļ�
				
				//����ͼƬ����
				u.setEmpPhoto(filename);
			}
		}
		
		this.sysUsersInfoService.update(u);
		mav.setViewName("redirect:listPage.do");//�ض���list����
		return mav;
	}


}
