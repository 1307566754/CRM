package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.entity.SysUsers;
import com.sc.service.KcCangkuService;
import com.sc.service.SysUsersService;

import net.bytebuddy.asm.Advice.This;

@Controller
@RequestMapping("/KCCKControllerCtrl")
public class KCCKController {
	
	@Autowired
	KcCangkuService kcCangkuService;
	
	@RequestMapping("/listPage.do")
	public ModelAndView listPage(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="3")Integer pageSize){
		
		mav.addObject("p", kcCangkuService.select(pageNum, pageSize));
		//��ת�����ֿ���Ϣ��ҳ��
		mav.setViewName("yjs/selectKCCKPage");
		
		System.out.println("��ҳ");
		
		return mav;
	}
}
