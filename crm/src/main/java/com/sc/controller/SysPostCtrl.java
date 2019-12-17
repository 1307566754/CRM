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

import com.github.pagehelper.PageInfo;
import com.sc.entity.SysPost;
import com.sc.entity.SysUserinfo;
import com.sc.entity.SysUsers;
import com.sc.service.SysPostService;
import com.sc.service.SysUsersService;

import net.bytebuddy.asm.Advice.This;

@Controller
@RequestMapping("/SysPostCtrl")
public class SysPostCtrl {
	
	@Autowired
	SysPostService sysPostService ;
	
	@RequestMapping("/listPage.do")
	public ModelAndView listPage(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="3")Integer pageSize){
		
		mav.addObject("p", sysPostService.select(pageNum, pageSize));
		mav.setViewName("ssf/POSTlistpage");
		System.out.println(sysPostService.select(pageNum, pageSize));
		
		System.out.println("��ҳ");
		
		return mav;
	}
	@RequestMapping("/goupdate.do")
	public ModelAndView goupdate(ModelAndView mav, SysPost u) {
		System.out.println("����goupdate����" + u.getPostId());
		SysPost p = sysPostService.get(u.getPostId());
		System.out.println("����PostId��ѯ��Ϣ��" + u);
		mav.addObject("u", p);
		mav.setViewName("ssf/updatePOST");

		return mav;
	}
	@RequestMapping("/update.do")
	public ModelAndView update(ModelAndView mav,HttpServletRequest req, SysPost u)
			throws IllegalStateException, IOException {
		System.out.println("�����޸ķ���");

		this.sysPostService.update(u);
		System.out.println(u);
		mav.setViewName("redirect:listPage.do");// �ض���list����
		return mav;
	}
	@RequestMapping("/delete.do")
	public ModelAndView delete(ModelAndView mav, SysPost s) {
		System.out.println("ɾ���û���" + s);
		this.sysPostService.del(s);
		mav.setViewName("redirect:listPage.do");// �ض���list����
		return mav;
	}
	@RequestMapping("/goadd.do")
	public ModelAndView goadd(ModelAndView mav, SysPost user) {

		mav.setViewName("ssf/POSTadd");
		return mav;
	}

	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav, MultipartFile upload, HttpServletRequest req, SysPost u)
			throws IllegalStateException, IOException {
		System.out.println("��ʼ����û�" + u);
		
		sysPostService.add(u);
			mav.setViewName("redirect:listPage.do");

		
		return mav;
	}
}
