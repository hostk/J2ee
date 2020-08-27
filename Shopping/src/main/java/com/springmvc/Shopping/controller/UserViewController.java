package com.springmvc.Shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.Shopping.services.ItemServices;

@Controller
public class UserViewController {
    
	@Autowired
	private ItemServices userService;
	
    @RequestMapping(value="/user_show_view.htm")
    public String viewHomePage(Model model) {
        model.addAttribute("items", userService.getItemList());
        model.addAttribute("cList",userService.getCatList());
        return "user_show_view";
    }
    @RequestMapping(value="/user_show")
    public String viewSearchPage(Model model,@RequestParam("search") String keyword) {
        model.addAttribute("items", userService.listAll(keyword));
        model.addAttribute("cList",userService.getCatList());
        System.out.println("Result keyword:"+keyword);
        return "user_show_view";
    }
  @RequestMapping(value="/selectCategory")
    public String viewSearchByCategory(Model model,@RequestParam("category")int id) {
        model.addAttribute("items", userService.getItemListByCategory(id));
        model.addAttribute("cList",userService.getCatList());
        System.out.println("Result keyword:"+id);
        return "user_show_view";
    }
	 
}
