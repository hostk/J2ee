package com.springmvc.Shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class HomeController {
	@RequestMapping(value="/admin/admin.htm", method=RequestMethod.GET)  
    public String home() {  
        return "home";  
    }
	@RequestMapping(value="/manager/manager.htm", method=RequestMethod.GET)  
    public String admin() {  
        return "admin";  
    }  
}
