package com.springmvc.Shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.Shopping.model.Item;
import com.springmvc.Shopping.services.ItemServices;

@Controller
public class UserViewController {
    
	@Autowired
	private ItemServices userService;
     
    @RequestMapping("/submit")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Item> listProducts = userService.listAll(keyword);
        model.addAttribute("items", listProducts);
        model.addAttribute("keyword", keyword);
        return "user_show_view";
    }
	 
}
