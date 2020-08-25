package com.hotelreservation.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotelreservation.dao.FoodItemDao;
import com.hotelreservation.dto.FoodItemDto;
import com.hotelreservation.model.Category;
import com.hotelreservation.model.Food;

@Service
@Transactional
public class FoodItemService {
	
	@Autowired
	ServletContext serveletContext;
	
	@Autowired
	FoodItemDao foodItemDao;
	
	public String Upload_Directory="resources/images/";
	
	public void saveCategory(Category category) {
		try {
			foodItemDao.saveCategory(category);	
		}catch(Exception e) {
			throw e;
		}
	}
	
	public List<Category> getCategoryList(){
		return foodItemDao.getCategoryList();
	}
	
	public void saveFoodItem(FoodItemDto foodDto) throws Exception {
//		if(foodDto!=null) {
//			String path=serveletContext.getRealPath(Upload_Directory);
//			String filename=foodDto.getFile().getOriginalFilename();
//			System.out.println(path+" "+filename);
//			
//			try {
//				byte[] bytes = foodDto.getFile().getBytes();
//				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(
//						new File(path+File.separator+filename)));
//				
//				out.write(bytes);
//				out.flush();
//				out.close();
//			}catch(Exception e) {
//				throw e;
//			}
			Food food=new Food(foodDto.getName(),foodDto.getPrice(),"img1.jpg",foodDto.getCategory());
			foodItemDao.saveFoodItem(food);
		}
	
	public List<Food> getFoodItemList(){
		return foodItemDao.getFoodItemList();
	}
}
