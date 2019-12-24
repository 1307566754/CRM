package com.sc.controller;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.KcCangku;
import com.sc.service.JhCgdxqService;
import com.sc.service.KcCangkuService;

@Controller
@RequestMapping("/KCCKControllerCtrl")//KCCK--�ֿ���
public class KCCKController {
	
	@Autowired
	KcCangkuService kcCangkuService;
	@Autowired
	JhCgdxqService jhCgdxqService;
	//��ҳ��ѯ
	@RequestMapping("/listPage.do")
	public ModelAndView listPage(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="10")Integer pageSize,KcCangku kcck){
		
		mav.addObject("p", kcCangkuService.select(pageNum, pageSize,kcck));
		//��תҳ��
		mav.setViewName("yjs/selectKCCKPage");
		
		System.out.println("��ҳ");
		
		return mav;
	}
	
	//�ɹ����
		@RequestMapping("/rukulistPage.do")
		public ModelAndView rukulistPage(ModelAndView mav,
				@RequestParam(defaultValue="1")Integer pageNum,
				@RequestParam(defaultValue="10")Integer pageSize,Long cgdId){
			
			mav.addObject("p", jhCgdxqService.selectpage(cgdId, pageNum, pageSize));
					
			//��תҳ��
			mav.setViewName("yjs/selectRukuPage");
			
			System.out.println("��ҳ");
			
			return mav;
		}
	
	//���
	 @RequestMapping("/add.do")//ȥ���
	 public ModelAndView addofficeKpi(ModelAndView mav){
		
		 mav.setViewName("yjs/addKCCKPage");
		 return mav;
		 }
	 
	 @RequestMapping("/addKCCK.do")//ִ�����
	 public ModelAndView addofficeKpi(ModelAndView mav,KcCangku kcck){
		kcck.setCangkuLastModifyTime(new Date());
		 System.out.println("��ӿ��ֿ�"+kcck);
		this.kcCangkuService.add(kcck);
		 mav.setViewName("redirect:listPage.do");
		 return mav;
		 }
	 //ɾ��-�ֿ�
	@RequestMapping("/delete.do")
	public ModelAndView delete(ModelAndView mav, Long kcck){
		System.out.println("ɾ���ֿ⣡"+kcck);
		kcCangkuService.delete(kcck);
		mav.setViewName("redirect:listPage.do");//�ض���list����
		return mav;
	}
	
	//ѡ��ɾ��--�ֿ�
	@RequestMapping("/kcckDeleteSelect.do")
	public ModelAndView kcgsDeleteSelect(ModelAndView mav,
									HttpServletRequest req,
									HttpServletResponse resp){
		
		String[] idsArr = req.getParameterValues("ckid");
		System.out.println("------����ɾ��ѡ��1:>"+idsArr.length);
		for (String gidStr : idsArr) {
			System.out.println("--------����ɾ��ѡ��2��>"+gidStr);
			Long gid = Long.parseLong(gidStr);
			
			System.out.println("--------����ɾ��ѡ��3��>"+gid);
			kcCangkuService.delete(gid);
		}
		
		mav.setViewName("redirect:listPage.do");
		return mav;
	}
	
	//ɾ��--�ɹ���
		@RequestMapping("/cgdxqDelete.do")
		public ModelAndView cgdxqDelete(ModelAndView mav,
									BigDecimal cgdxqId,
									Long cgdId){
			
			jhCgdxqService.delete(cgdxqId);
			System.out.println("------------------>�ɹ�������ɾ��"+cgdxqId);
			mav.addObject("cgdId", cgdId);
			mav.setViewName("redirect:cgdxqList.do?");// ·���ǣ�/WEB-INF/userslistpage.jsp
			return mav;
		}
		
		//ɾ��ѡ��--�ɹ���
			@RequestMapping("/cgdxqDeleteSelect.do")
			public ModelAndView cgdxqDeleteSelect(ModelAndView mav,
												HttpServletRequest req,
												Long cgdId){
				
				String[] idsArr = req.getParameterValues("cgdxqId");
				System.out.println("------------------>�ɹ�������ѡ��ɾ��"+idsArr.length);
				for (String cgdxqIdStr : idsArr) {
					BigDecimal cgdxqId = new BigDecimal(cgdxqIdStr);
					System.out.println("-------------->"+cgdxqId);
					jhCgdxqService.delete(cgdxqId);
				}
				System.out.println("cgdid-----------------------"+cgdId);
				
				mav.addObject("cgdId", cgdId);
				mav.setViewName("redirect:cgdxqList.do");// ·���ǣ�/WEB-INF/userslistpage.jsp
				return mav;
			}	
	//�޸�
	 @RequestMapping("/goupdate.do")
	 public ModelAndView goupdate(ModelAndView mav,Long cangkuId ){
			System.out.println("������goupdate");
			mav.addObject("kcck", kcCangkuService.getCkID(cangkuId));
			mav.setViewName("yjs/updateKCCKPage");
			return mav;
		}
	 @RequestMapping("/update.do")
	 public ModelAndView OfficeKpiupdate(ModelAndView mav,KcCangku kcck){
		 kcck.setCangkuLastModifyTime(new Date());
		 System.out.println("�޸Ĳֿ���Ϣ"+kcck);
		this.kcCangkuService.update(kcck);
		 mav.setViewName("redirect:listPage.do");
		 return mav;
	 }
	
}
