package com.spring.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Webinitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	@Override
	protected Class<?>[] getRootConfigClasses(){
		return new Class<?>[] {RootConfig.class};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses(){
		return new Class<?>[] {WebConfig.class, SwaggerConfig.class};
	}
	
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
//		return new String[] {"*.do"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		
		return new Filter[] {encodingFilter};
	}
}
