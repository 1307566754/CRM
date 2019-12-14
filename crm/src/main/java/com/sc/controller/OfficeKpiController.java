package com.sc.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.OfficeKpi;

import com.sc.service.OfficeKpiService;

@Controller
@RequestMapping("/OfficeKpictrl")
public class OfficeKpiController {
	 @Autowired 
	 OfficeKpiService OfficeKpiService ;
	 @RequestMapping("/list.do")
		public ModelAndView list(ModelAndView mav){
			
			List<OfficeKpi> list = this.OfficeKpiService.select();
			mav.addObject("list", list);
			mav.setViewName("OA/OfficeKpilistpage");// /WEB-INF/userslist.jsp
			return mav;
		}
	 //@RequestMapping("/delete.do")
	 
	
	 @RequestMapping("/listpage.do")
	   public ModelAndView listpage(ModelAndView mav,@RequestParam(defaultValue="1") Integer pageNum,
			@RequestParam(defaultValue="5") Integer pageSize){
		System.out.println("----");
		
		mav.addObject("p",OfficeKpiService.selectpage(pageNum,pageSize));
		
		mav.setViewName("OA/OfficeKpilistpage");
		return mav;
		}
	 
	 @RequestMapping("/upload.do")
		public ModelAndView upload(ModelAndView mav,
				MultipartFile upload,
				HttpServletRequest req) throws IllegalStateException, IOException{
			System.out.println("��ʼ�ϴ��ļ�");
			
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
					
					//����ͼƬ����,ҳ����ʾͼƬ
					mav.addObject("pic", filename);
				}
			}
			
			mav.setViewName("show");// ·���ǣ�/WEB-INF/show.jsp
			return mav;
		}
	 @RequestMapping("/delete.do")
		public ModelAndView delete(ModelAndView mav,OfficeKpi k){
			System.out.println("ɾ������ָ�꣡"+k);
			this.OfficeKpiService.delete(k);
			mav.setViewName("redirect:listpage.do");//�ض���list����
			return mav;
		}
	 @RequestMapping("/goupdate.do")
	 public ModelAndView goupdate(ModelAndView mav,BigDecimal kpiId){
			System.out.println("�޸�֮ǰ�Ȳ鿴");
			mav.addObject("kpi", OfficeKpiService.get(kpiId));
			mav.setViewName("OA/OfficeKpigoupdate");
			return mav;
		}
	 @RequestMapping("OfficeKpiupdate.do")
	 public ModelAndView OfficeKpiupdate(ModelAndView mav,OfficeKpi kpi){
		 kpi.setFinalUpdataTime(new Date());
		 System.out.println("�޸ÿ�������"+kpi);
		this.OfficeKpiService.update(kpi);
		 mav.setViewName("redirect:listpage.do");
		 return mav;
	 }
	 @RequestMapping("/addofficeKpi.do")
	 public ModelAndView addofficeKpi(ModelAndView mav,OfficeKpi k){
		k.setFinalUpdataTime(new Date());
		 System.out.println("��ӿ�������"+k);
		 this.OfficeKpiService.add(k);
		 mav.setViewName("redirect:listpage.do");
		 return mav;
		 }
	 @RequestMapping("/inaddofficeKpi.do")
		public ModelAndView inaddofficeKpi(ModelAndView mav){
			mav.setViewName("OA/addofficeKpi");
			return mav;
			}
}
