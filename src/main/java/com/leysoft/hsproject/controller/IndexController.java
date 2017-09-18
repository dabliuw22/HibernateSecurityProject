package com.leysoft.hsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.leysoft.hsproject.service.interf.UserService;

@Controller
public class IndexController {
	
	@Autowired @Qualifier("userService")
	private UserService userService;
	
	@GetMapping(value = "/")
	public String index(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("user", userService.findByUsername(authentication.getName()));
		return "index";
	}
}
