package com.sc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.OffMess;
import com.sc.service.OffMessService;

@Controller
@RequestMapping("/offmessctrl")
public class OffMessController {
	
	@Autowired
	OffMessService offMessService;
	
	
	
	@RequestMapping("/listpage.do")
	public ModelAndView listpage(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="5")Integer pageSize){
		System.out.println("�������Ϣ����������");
		
		//��ѯlist���Ϸ�ҳ
		mav.addObject("p", offMessService.selectdeta(pageNum, pageSize,"����"));
		
		mav.setViewName("OFF/mailbox");// ·��/WEB-INF/userslistpage.jsp
		return mav;
	}
	
	@RequestMapping("/goadd.do")
	public ModelAndView goadd(ModelAndView mav){
		mav.setViewName("OFF/mail_compose");
		return mav;
	}
	
	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav,MultipartFile upload,HttpServletRequest req,
			OffMess m) throws IllegalStateException, IOException{
		System.out.println("��ʼ���Ͷ���Ϣ"+m);
		
		this.offMessService.add(m);
		mav.setViewName("redirect:listpage.do");//�ض���listpage����
		return mav;
	}
	
	
	

}
