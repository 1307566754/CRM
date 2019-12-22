package com.sc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sc.interceptor.SysLogInterceptor;

@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurerAdapter  {

	
	   @Autowired
	    private SysLogInterceptor sysLogInterceptor;

	  /*  @Override
	    protected void addInterceptors(InterceptorRegistry registry) {
	        // ������������һ����������
	        // addPathPatterns ����������ع���/**��ʾ������������
	        // excludePathPatterns �û��ų�����
	        registry.addInterceptor(sysLogInterceptor).addPathPatterns("/**")
	        .excludePathPatterns("/css/**","/fonts/**"
	        		,"/html/**","/images/**","/js/**",
	        		"/My97DatePicker/**","/plugins/**",
	        		"/upload/**","/error**");  
	        super.addInterceptors(registry);
	    }*/
	    
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	    	registry.addInterceptor(sysLogInterceptor).addPathPatterns("/**")
	        .excludePathPatterns("/css/**","/fonts/**"
	        		,"/html/**","/images/**","/js/**",
	        		"/My97DatePicker/**","/plugins/**",
	        		"/upload/**","/error**","/sql/**","/img/**");  
	    	super.addInterceptors(registry);
	    }
	    
	   /*@Override
	    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	        super.addResourceHandlers(registry);
	    }*/

	   
	   
}
