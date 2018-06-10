package com.example.demo.controler;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class Usercontroler {
	@GetMapping("/login")
	public String web1() {
		return "login";	
	}
	@GetMapping("/")
	public String myindex() {
//		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
//				.getAuthentication()
//				.getPrincipal();
		return "index";
	}
	
}                                                                                            