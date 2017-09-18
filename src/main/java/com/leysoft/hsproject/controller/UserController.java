package com.leysoft.hsproject.controller;

import java.util.ArrayList;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leysoft.hsproject.entity.RolUser;
import com.leysoft.hsproject.entity.User;
import com.leysoft.hsproject.service.interf.RolUserService;
import com.leysoft.hsproject.service.interf.UserService;

@Controller
public class UserController {
	
	@Autowired @Qualifier("userService")
	private UserService userService;
	
	@Autowired @Qualifier("rolUserService")
	private RolUserService rolUserService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping(value = "/form-user")
	public ModelAndView formUser() {
		ModelAndView mav = new ModelAndView("registro");
		mav.addObject("user", new User());
		return mav;
	}
	
	@PostMapping(value = "/registro")
	public ModelAndView registro(@Valid @ModelAttribute("user") User user,
			BindingResult result) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", user);
		if(result.hasErrors() 
				|| !userService.isUniqueUsername(user.getUsername()) 
				|| !userService.isUniqueEmail(user.getEmail())) {
			System.out.println("Error!!!");
			mav.setViewName("registro");
		} else {
			mav.setViewName("index");
			List<RolUser> roles = new ArrayList<>();
			roles.add(rolUserService.findByTipo("USER"));
			user.setRoles(roles);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userService.save(user);
		}
		return mav;				
	}
	
	@GetMapping(value = "/user")
	public String userView(Model model) {
		return "user";
	}
	
	@GetMapping(value = "/admin")
	public String adminView(Model model) {
		return "admin";
	}
	
	@GetMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	/*
	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}*/
	
	@GetMapping(value = "/access_denied")
	public String accessDenied(Model model) {
		return "403";
	}
}
