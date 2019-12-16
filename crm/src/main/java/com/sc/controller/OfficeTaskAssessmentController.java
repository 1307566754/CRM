package com.sc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.OfficeKpi;
import com.sc.entity.OfficeTaskAssessment;
import com.sc.service.OfficeTaskAssessmentService;
@Controller
@RequestMapping("/OfficeTaskAssessmentController")
public class OfficeTaskAssessmentController {
	  @Autowired 
	OfficeTaskAssessmentService OfficeTaskAssessmentService;
    @RequestMapping("/list.do")
    public ModelAndView list(ModelAndView mav){
    	List<OfficeTaskAssessment> list = this.OfficeTaskAssessmentService.select();
		mav.addObject("list", list);
		mav.setViewName("OA/OfficeTaskAssessmentListpage");// /WEB-INF/userslist.jsp
    	return mav;
    }
    @RequestMapping("/listpage.do")
	   public ModelAndView listpage(ModelAndView mav,@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="5") Integer pageSize){
		System.out.println("----");
		
		mav.addObject("p",OfficeTaskAssessmentService.selectpage(pageNum,pageSize));
		
		mav.setViewName("OA/OfficeTaskAssessmentListpage");
		return mav;
		}
    //��ҳ��ѯ
    @RequestMapping("/delete.do")
    public ModelAndView delete(ModelAndView mav,OfficeTaskAssessment t){
    	System.out.println("ɾ������"+t);
    	this.OfficeTaskAssessmentService.delete(t);
		mav.setViewName("redirect:listpage.do");//�ض���list����
    	return mav;
    }
    @RequestMapping("/inaddOfficeTaskAssessment.do")
	public ModelAndView inaddofficeKpi(ModelAndView mav){
		mav.setViewName("OA/addOfficeTaskAssessment");
		return mav;
		}
    @RequestMapping("/add.do")
    public ModelAndView add(ModelAndView mav,OfficeTaskAssessment t){
    	System.out.println("����µ�����"+t);
    	this.OfficeTaskAssessmentService.add(t);
    	mav.setViewName("redirect:listpage.do");//�ض���list����
    	return mav;
    }
    
    @RequestMapping("/update.do")
    public ModelAndView update(ModelAndView mav,OfficeTaskAssessment t){
    	System.out.println("����µ�����"+t);
    	this.OfficeTaskAssessmentService.update(t);
    	mav.setViewName("redirect:listpage.do");//�ض���list����
    	return mav;
    }
}
