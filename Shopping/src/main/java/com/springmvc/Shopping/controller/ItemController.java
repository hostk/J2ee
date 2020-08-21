package com.springmvc.Shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.Shopping.model.Category;
import com.springmvc.Shopping.model.Item;
import com.springmvc.Shopping.services.ItemServices;

@Controller
public class ItemController {

	@Autowired
	private ItemServices itemServices;
	
	@RequestMapping(value="/newItem.htm")
	public String createItem(Model model) {
		model.addAttribute("iList",new Item());
		model.addAttribute("cList",itemServices.getCatList());
		return "newItem";
	}
	
	@RequestMapping(value="/newItem.htm",method=RequestMethod.POST)
	public String saveItem(@ModelAttribute(value="iList") Item iList) throws Exception {
		itemServices.saveItem(iList);
		return "redriect:/item_list.htm";
	}
	
	@RequestMapping(value="/item_list.htm")
	public String showItem(Model model) {
		model.addAttribute("items", itemServices.getItemList());
		return "item_list";
	}
	@RequestMapping(value="/new_category.htm")
	public String createCategory(Model model) {
		model.addAttribute("cList",new Category());
		return "new_category";
	}
	
	@RequestMapping(value="/new_category.htm",method=RequestMethod.POST)
	public String saveCategory(@ModelAttribute(value="cList") Category cList) throws Exception {
		itemServices.saveCategory(cList);
		return "redriect:/item_list.htm";
	}
	
	@RequestMapping(value="/category_list.htm")
	public String showCategory(Model model) {
		model.addAttribute("category", itemServices.getCatList());
		return "item_list";
	}
}
