package com.sc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.Message;
import com.sc.entity.SysCompanyinfo;
import com.sc.entity.SysUsers;
import com.sc.service.SysCompanyInfoService;

@Controller
@RequestMapping("/LoginCtrl")
public class LoginCtrl {
	
	@Autowired
	SysCompanyInfoService sysCompanyInfoService;
	
	
	@RequestMapping("/login.do") 
	//�����ĵ�ַ�ǣ�http://localhost:8080/springMVC1/loginctrl/login.do
	public ModelAndView login(ModelAndView mav,HttpServletRequest req){//������Ĳ���ֵ�Զ���װ�����������
		
		System.out.println("�û���֤ʧ��");
		
		String msg = (String)req.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);		

		System.out.println("��֤ʧ����Ϣ"+msg);
		String fail="";
		if(msg!=null){
			if(msg.equals(UnknownAccountException.class.getName())){
				fail="unknown";//�û���������
			}else if(msg.equals(IncorrectCredentialsException.class.getName())){
				fail="error";//�������
			}else if(msg.equals("randomCodeError")){
				fail="code";//��֤�����
			}else{
				fail="other";//��������
			}
		}
		
		mav.setViewName("redirect:../login.jsp?isfail="+fail);//������ͼ����,�ض���login.jsp

		return mav;
	}
	
	@RequestMapping("/main.do") 
	//�����ĵ�ַ�ǣ�http://localhost:8080/springMVC1/loginctrl/login.do
	public ModelAndView main(ModelAndView mav,HttpSession session){
		System.out.println("�û���֤�ɹ�");
		//��ȡ����
		Subject sub = SecurityUtils.getSubject();
		SysUsers user=(SysUsers) sub.getPrincipal();
		System.out.println("������"+user.toString());
		session.setAttribute("nowuser", user);
		mav.setViewName("redirect:../main.jsp");
		
		return mav;
		
		
	}
	
	@RequestMapping("/checkcId.do")
	@ResponseBody
	public Message checkcId(SysCompanyinfo sci,HttpServletRequest req){
		
		System.out.println("��֤��˾����");
		HttpSession session = req.getSession();
		Message msg=null;
		SysCompanyinfo companyinfo = this.sysCompanyInfoService.get(sci.getPk());
		if(companyinfo!=null){
			session.setAttribute("cinfo", companyinfo);
			msg=new Message("200", "no", "��˾�������");
		}else{
			msg=new Message("100", "yes", "��˾���벻����");
		}
		return msg;
	}
}
