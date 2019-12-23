package com.sc.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.SysLog;
import com.sc.entity.SysPowerinfo;
import com.sc.service.SysLogService;
import com.sc.service.SysPowerinfoService;

@Component
public class SysLogInterceptor implements HandlerInterceptor {

	@Autowired
	SysPowerinfoService sysPowerinfoService;
	@Autowired
	SysLogService sysLogService;
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("���ؼ�¼��־-----start");
		System.out.println("��ǰ�����uri��ַ�ǣ�"+request.getRequestURI());
		String substring = request.getRequestURI().substring(4);
		System.out.println("��ȡ��������uri��ַ�ǣ�"+substring);
		 String ip = request.getHeader("x-forwarded-for");  
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		        ip = request.getHeader("Proxy-Client-IP");  
		    }  
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		        ip = request.getHeader("WL-Proxy-Client-IP");  
		    }  
		    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
		        ip = request.getRemoteAddr();  
		    }  
		System.out.println("��ȡ��������ip�ǣ�"+ip);
		//��Ȩ�ޱ��в�ѯ��Ӧ��uri��ַ����ȡ�������ƣ������ĵ����ͱ��浽��־����
		SysPowerinfo powerinfo = this.sysPowerinfoService.selectBypUrl(substring);
		if(powerinfo!=null){
			SysLog log = new SysLog();
			log.setPower(powerinfo.getPowerName());
			log.setVisitIp(ip);
			log.setVisitDate(new Date());
			log.setUserId(61L);
			this.sysLogService.insert(log);
		}
		System.out.println("���ؼ�¼��־-----end");
        //ҵ�����
        return true;
	}

	
	
}
