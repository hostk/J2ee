package com.springmvc.Shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.Shopping.model.PurchaseItem;
import com.springmvc.Shopping.services.ItemServices;
import com.springmvc.Shopping.services.PurchaseService;

@Controller
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired 
	ItemServices itemService;
	
	@RequestMapping(value="/new_purchase.htm")
	public String createPurchase(Model model) {
		model.addAttribute("purchases",new PurchaseItem());
		model.addAttribute("items",itemService.getItemList());
		return "new_purchase";
	}
	
	@RequestMapping(value="/new_purchase.htm",method=RequestMethod.POST)
	public String savePurchase(@ModelAttribute(value="purchases")PurchaseItem purchase) throws Exception{
		purchaseService.savePurchase(purchase);
		return "redirect:/purchase_list.htm";
	}
	
	@RequestMapping(value="/purchase_list.htm")
	public String showPurchase(Model model) {
		model.addAttribute("purchases",purchaseService.getPurchaseItem());
		return "purchase_list";
	}
	
}
