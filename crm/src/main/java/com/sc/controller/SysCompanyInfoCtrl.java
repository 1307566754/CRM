package com.sc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.SysCompanyinfo;
import com.sc.entity.SysDept;
import com.sc.service.SysCompanyInfoService;

@Controller
@RequestMapping("/SysCompanyInfoCtrl")
public class SysCompanyInfoCtrl {
	@Autowired 
	SysCompanyInfoService sysCompanyInfoService;
	@RequestMapping("/listPage.do")
	public ModelAndView listPage(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="5")Integer pageSize){
		
		mav.addObject("p", sysCompanyInfoService.select(pageNum, pageSize));
		mav.setViewName("ssf/CompangINFOlist");
		System.out.println(sysCompanyInfoService.select(pageNum, pageSize));
		
		System.out.println("��ҳ");
		
		return mav;
	}
	@RequestMapping("/delete.do")
	public ModelAndView delete(ModelAndView mav, SysCompanyinfo s) {
		System.out.println("ɾ���û���" + s);
		this.sysCompanyInfoService.del(s);
		mav.setViewName("redirect:listPage.do");// �ض���list����
		return mav;
	}
	@RequestMapping("/goupdate.do")
	public ModelAndView goupdate(ModelAndView mav, SysCompanyinfo u) {
		System.out.println("����goupdate����" + u.getPk());
		SysCompanyinfo p = sysCompanyInfoService.get(u.getPk());
		System.out.println("����deptId��ѯ��Ϣ��" + p);
		mav.addObject("u", p);
		mav.setViewName("ssf/updateCompanyInfo");

		return mav;
	}

	@RequestMapping("/update.do")
	public ModelAndView update(ModelAndView mav, HttpServletRequest req, SysCompanyinfo u)
			throws IllegalStateException, IOException {
		System.out.println("�����޸ķ���");

		this.sysCompanyInfoService.update(u);
		System.out.println("�޸ĳɹ���"+u);
		mav.setViewName("redirect:listPage.do");// �ض���list����
		return mav;
	}
	@RequestMapping("/goadd.do")
	public ModelAndView goadd(ModelAndView mav, SysCompanyinfo user) {

		mav.setViewName("ssf/CompanyInfoadd");
		return mav;
	}
	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav, MultipartFile upload, HttpServletRequest req, SysCompanyinfo u)
			throws IllegalStateException, IOException {
		System.out.println("��ʼ����û�" + u);
		sysCompanyInfoService.add(u);
		mav.setViewName("redirect:listPage.do");
		return mav;
	}
}
