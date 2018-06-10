package com.example.demo.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
//加载webbSecurityConfig类信息
public class SecurityWebApplicationInitializer
	extends AbstractSecurityWebApplicationInitializer {

	public SecurityWebApplicationInitializer() {
		super(WebSecurityConfig.class);
	}
}