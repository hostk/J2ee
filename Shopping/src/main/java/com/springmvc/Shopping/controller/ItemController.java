package com.springmvc.Shopping.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.Shopping.dto.ItemDTO;
import com.springmvc.Shopping.model.Category;
import com.springmvc.Shopping.services.ItemServices;

@Controller
public class ItemController {

	@Autowired
   // @Qualifier(value="itemServices")
	private ItemServices itemServices;
	
	@RequestMapping(value="/newItem.htm")
	public String createItem(Model model) {
		model.addAttribute("iList",new ItemDTO());
		model.addAttribute("cList",itemServices.getCatList());
		return "newItem";
	}
	
	@RequestMapping(value="/newItem.htm",method=RequestMethod.POST)
	public String saveItem(@Valid @ModelAttribute(value="iList") ItemDTO iList,BindingResult result) throws Exception {
		try {
			itemServices.saveItem(iList);
			return "redirect:/item_list.htm";
//			if(result.hasErrors()) {
//				return "newItem";
//			}else {
//				
//			}
		}catch(Exception e) {
			//return "newItem";
			throw e;
		}
	}
	
	@RequestMapping(value="/item_list.htm")
	public String showItem(Model model) {
		model.addAttribute("items", itemServices.getItemList());
		return "item_list";
	}
	@RequestMapping(value="/new_category.htm")
	public String createCategory(Model model) {
		model.addAttribute("categoryList",new Category());
		return "new_category";
	}
	
	@RequestMapping(value="/new_category.htm",method=RequestMethod.POST)
	public String saveCategory(@ModelAttribute(value="categoryList") Category cList) throws Exception {
		itemServices.saveCategory(cList);
		return "redirect:/category_list.htm";
	}
	
	@RequestMapping(value="/category_list.htm")
	public String showCategory(Model model) {
		model.addAttribute("categorys", itemServices.getCatList());
		return "category_list";
	}
	
}
