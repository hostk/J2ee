package com.hotelreservation.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotelreservation.dto.FoodItemDto;
import com.hotelreservation.model.Category;
import com.hotelreservation.services.FoodItemService;

@Controller
public class FoodItemController {

	@Autowired
	private FoodItemService Dtoservice;

	@RequestMapping(value = "/newFoodItem.htm")
	public String createFoodItem(Model model) {
		model.addAttribute("foodList", new FoodItemDto());
		model.addAttribute("categoryList", Dtoservice.getCategoryList());
		return "newFoodItem";

	}

	@RequestMapping(value = "/newFoodItem.htm", method = RequestMethod.POST)
	public String saveFoodItem(@Valid @ModelAttribute(value = "foodList") FoodItemDto food, BindingResult result)
			throws Exception {
		try {
			Dtoservice.saveFoodItem(food);
			return "redirect:/foodItemList.htm";
//			if (result.hasErrors()) {
//				return "newFoodItem";
//
//			} else {
//				
//			}
		} catch (Exception e) {
			throw e;
			}
	}

	@RequestMapping(value = "/foodItemList.htm")
	public String showFoodItem(Model model) {
		model.addAttribute("foodList", Dtoservice.getFoodItemList());
		return "foodItemList";
	}

	@RequestMapping(value = "/newCategory.htm")
	public String createCategory(Model model) {
		model.addAttribute("categoryList", new Category());
		return "newCategory";
	}

	@RequestMapping(value = "/newCategory.htm", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute(value = "categoryList") Category cats) {
		try {
			Dtoservice.saveCategory(cats);
			return "redirect:/newFoodItem.htm";
		} catch (Exception e) {
			return "newCategory.htm";
		}

	}
}
