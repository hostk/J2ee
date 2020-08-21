package com.springmvc.Shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.Shopping.model.Item;
import com.springmvc.Shopping.model.SaleItem;
import com.springmvc.Shopping.services.ItemServices;

@Controller
public class SaleController {
	@Autowired
	private ItemServices itemServices;
	
	@RequestMapping(value="/new_sale.htm")
	public String createSale(Model model) {
		model.addAttribute("sList",new SaleItem());
		model.addAttribute("itemList",itemServices.getItemList());
		return "new_item";
	}
	
	@RequestMapping(value="/new_sale.htm",method=RequestMethod.POST)
	public String saveSale(@ModelAttribute(value="sList") SaleItem sList) throws Exception {
		itemServices.saveSaleItem(sList);
		return "redriect/sale_list.htm";
	}
	
	@RequestMapping(value="/sale_list.htm")
	public String showSale(Model model) {
		model.addAttribute("sales", itemServices.getSaleItem());
		return "sale_list";
	}
}
