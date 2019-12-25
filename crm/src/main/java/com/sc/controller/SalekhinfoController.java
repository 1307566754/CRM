package com.sc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.SaleKhcontacts;
import com.sc.entity.SaleKhinfo;
import com.sc.service.SaleService;

@Controller
@RequestMapping("/SalekhinfoController")
public class SalekhinfoController {
	
	@Autowired
	SaleService saleService;
	//�ͻ���Ϣ
	@RequestMapping("/list.do")
	public ModelAndView list(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="10")Integer pageSize,
			SaleKhinfo s,String iscg){
		
		mav.addObject("p", saleService.select(pageNum, pageSize, s));
		if(iscg!=null){
			mav.addObject("iscg", "yes");
		}
		mav.setViewName("wlq/Khinfo");
		
		return mav;
	}
	
	@RequestMapping("/lxlist.do")
	public ModelAndView lxlist(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="10")Integer pageSize,
			String name,
			String id ){
		
		System.out.println(name);
		
		mav.addObject("q", saleService.lxselect(pageNum, pageSize));
		mav.addObject("name", name);
		mav.addObject("id", id);
		mav.setViewName("wlq/lxinfo");
		
		return mav;
	}
	
	@RequestMapping("/update.do")
	public ModelAndView update(ModelAndView mav,
			HttpServletRequest req,
			SaleKhinfo s){
		s.setLastModified(new Date());
		this.saleService.update(s);
		mav.setViewName("redirect:list.do");//�ض���list����
		return mav;		
	}
	
	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav,
			HttpServletRequest req,
			SaleKhinfo s){
		s.setLastModified(new Date());
		this.saleService.add(s);
		mav.addObject("iscg", "yes");
		mav.setViewName("redirect:list.do?iscg=yes");
		return mav;
}
	//��ϵ��
	@RequestMapping("/lxcx.do")
	public ModelAndView lxcx(ModelAndView mav,
			HttpSession se,
			Long id,
			String name){
		if(id==null){		
			id=(Long)se.getAttribute("id");
		}
		if(name==null){
			name=(String)se.getAttribute("name");
		}
		mav.addObject("q", saleService.lxcx(id));
		se.setAttribute("id", id);
		se.setAttribute("name", name);
		mav.setViewName("wlq/lxinfo");
		
		return mav;
		
	}
	
	@RequestMapping("/lxupdate.do")
	public ModelAndView lxupdate(ModelAndView mav,
			HttpServletRequest req,
			SaleKhcontacts c){
	
		this.saleService.lxupdate(c);
		mav.setViewName("redirect:lxcx.do");//�ض���list����
		return mav;		
	}
	
	@RequestMapping("/golxadd.do")
	public ModelAndView golxadd(ModelAndView mav,
			Long id){
		mav.addObject("id",id);
		mav.setViewName("wlq/Khlxadd");
		return mav;
		
	}
	
	@RequestMapping("/lxadd.do")
	public ModelAndView lxadd(ModelAndView mav,
			HttpServletRequest req,
			SaleKhcontacts c){
		
		this.saleService.lxadd(c);
		mav.addObject("iscg", "yes");
		mav.setViewName("redirect:lxcx.do?iscg=yes");
		return mav;
}
	@RequestMapping("/lxdelete.do")
	public ModelAndView lxdelete(ModelAndView mav,
			Long cid){
		System.out.println("ɾ���û���"+cid);
		this.saleService.lxdelete(cid);
		mav.setViewName("redirect:lxcx.do");//�ض���list����
		return mav;
	}
}
