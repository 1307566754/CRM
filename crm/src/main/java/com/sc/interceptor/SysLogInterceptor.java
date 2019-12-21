package com.sc.interceptor;

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
		String ip;
		 if (request.getHeader("x-forwarded-for") == null) {  
		     ip=request.getRemoteAddr();  
		 }else{
			 ip=request.getHeader("x-forwarded-for");
		 }
		System.out.println("��ȡ��������ip�ǣ�"+request.getRemoteAddr());
		//��Ȩ�ޱ��в�ѯ��Ӧ��uri��ַ����ȡ�������ƣ������ĵ����ͱ��浽��־����
		SysPowerinfo powerinfo = this.sysPowerinfoService.selectBypUrl(substring);
		SysLog log = new SysLog();
		if(powerinfo!=null){
			
		}
		System.out.println("���ؼ�¼��־-----end");
        //ҵ�����
        return true;
	}

	
	
}
