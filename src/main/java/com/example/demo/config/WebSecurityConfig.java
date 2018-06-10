package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
//@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	 protected void registerAuthentication(AuthenticationManagerBuilder auth) {
//	 try {
//	 auth.inMemoryAuthentication().withUser("user") // #1
//	 .password("password").roles("USER").and().withUser("admin") // #2
//	 .password("password").roles("ADMIN", "USER");
//	 } catch (Exception e) {
//	 // TODO Auto-generated catch block
//	 e.printStackTrace();
//	 }
//	 }
//	
//	 @Override
//	 public void configure(WebSecurity web) throws Exception {
//	 web.ignoring().antMatchers("/resources/**"); // #3//一盘css,imger,字体
//	 }
//	
//	 @Override
//	 protected void configure(HttpSecurity http) throws Exception {
//		 http.authorizeRequests()
//		 			.antMatchers("/signup", "/about","/login").permitAll() // #4// 这几个url放行不需要权限认证
//		 			.antMatchers("/admin/**").hasRole("ADMIN") // #6//这个url只有ADMIN可以访问
//		 			.anyRequest().authenticated() // #7//其他的url需要验证
//		 			.and()
//		 	 .formLogin() // #8//
//		 	 		.loginPage("/login") // #9//可以不写的，写了的话就是自己要再写一个登陆页面
//		 	 		.permitAll(); // #5
//	 }
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("李胜山").password("123456").roles("USER");
	 
	}
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/login").permitAll()   //url以login为后缀的都放行
				.antMatchers("/admin/").hasRole("ADMIN")//
				.anyRequest().authenticated()//这个设置除了指定URL其他都需要验证
				.and()
			.formLogin()      //
				.loginPage("/login") //可以不写的，写了的话就是自己要再写一个登陆页面
				.and()
			.httpBasic()//允许用户使用http基于验证进行认证
				.and()
			.logout()  //提供注销支持 ，AntPathRequestMatcher会自动应用   
				//.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));//提供注销支持并且指定跳转页面
				.logoutSuccessUrl("/login");
		
		http.csrf()
			.disable();//禁用csrf
		  //.and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()); // 等于disable
	}
}
