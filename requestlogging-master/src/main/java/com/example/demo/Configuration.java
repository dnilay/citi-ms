package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class Configuration implements WebMvcConfigurer {

	@Autowired
	private LogInterceptor logInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(logInterceptor);
	}

}
