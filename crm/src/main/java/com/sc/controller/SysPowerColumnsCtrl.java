package com.sc.controller;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.sc.entity.SysPowerColumns;
import com.sc.entity.SysUsers;
import com.sc.service.SysPowerColumnsService;
import com.sc.service.SysUsersService;
import com.sc.service.impl.SysPowerColumnsServiceImpl;

import oracle.sql.DATE;

@Controller
@RequestMapping("/SysPowerColumnsCtrl")
public class SysPowerColumnsCtrl {
	
	@Autowired
	SysPowerColumnsService sysPowerColumnsService;
	
	@Autowired
	SysUsersService sysUsersService;
	@Autowired
	HttpSession session;
	
	@RequestMapping("/inAddPowerColumns.do")
	public ModelAndView inAddPowerColumns(ModelAndView mav){
		
		mav.setViewName("wangyi/addpowercolumns");
		return mav;
		
	}
	
	@RequestMapping("/addPowerColumns.do")
	public ModelAndView addPowerColumns(ModelAndView mav,SysPowerColumns spc) throws SQLException{
		
		System.out.println("����"+spc.getColumnsName());
		System.out.println("ע�⣺"+spc.getRemarks());
		Date date = new Date();
		spc.setChangeDate(date);
		this.sysPowerColumnsService.addSysPowerColumns(spc);
		System.out.println("��ӳɹ�");
		mav.addObject("issuc", "yes");
		mav.setViewName("wangyi/addpowercolumns");
		return mav;
		
	}
	
	@RequestMapping("/PowerinfoList.do")
	public ModelAndView PowerinfoList(ModelAndView mav,
			@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="1000")Integer pageSize){
		SysUsers user=(SysUsers)this.session.getAttribute("nowuser");
		SysUsers sysUsers = new SysUsers();
		sysUsers.setUsersId(user.getUsersId());
		mav.addObject("p", this.sysPowerColumnsService.selectList(pageNum, pageSize,sysUsers));
		mav.setViewName("wangyi/powerinfolist");
		return mav;
		
	}
	
}
