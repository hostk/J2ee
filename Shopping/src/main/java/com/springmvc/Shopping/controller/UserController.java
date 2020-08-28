package com.springmvc.Shopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.Shopping.dto.UserDTO;
import com.springmvc.Shopping.services.UserServiceInterface;

@Controller
public class UserController {
	@Autowired
	UserServiceInterface userInfoService;
	
	@RequestMapping(value="/register.htm",method=RequestMethod.GET)
	public String register(Model model){
		model.addAttribute("userDTO", new UserDTO());
		model.addAttribute("roleList",userInfoService.getUserRoles());
		return "userRegister";
	}
	@RequestMapping(value="/register.htm",method=RequestMethod.POST)
	public String postRegister(@ModelAttribute(value="userDTO")UserDTO userDTO ){
		userInfoService.saveUser(userDTO);
		return "redirect:/login.htm";
	}
	@RequestMapping(value="/login.htm")
	public String login(Model model){
		return "login";
	}
	@RequestMapping(value="/403.htm")
	public String accessDenied(Model model){
		return "accessDenied";
	}
	 @RequestMapping(value="/logout.htm", method=RequestMethod.GET)  
	    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
	        if (auth != null){      
	           new SecurityContextLogoutHandler().logout(request, response, auth);  
	        }  
	         return "redirect:/login.htm";  
	     } 
	 @RequestMapping(value="/index.htm")
	 public String index(){
			return "index";
		}
	

}
