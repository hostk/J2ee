package com.springmvc.Shopping.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.Shopping.dao.ItemDao;
import com.springmvc.Shopping.dto.ItemDTO;
import com.springmvc.Shopping.model.Category;
import com.springmvc.Shopping.model.Item;
import com.springmvc.Shopping.model.PurchaseItem;
import com.springmvc.Shopping.model.SaleItem;

@Service
@Transactional
public class ItemServices {
	@Autowired
	ServletContext serveletContext;

	
	@Autowired
	ItemDao itemDao;
	ItemDao iDao;
	public String UPLOAD_DIRECTORY="/images/";
	@Transactional
	public void saveCategory(Category category) throws Exception{
		try {
			itemDao.saveCategory(category);
		}catch(Exception ex) {
			throw ex;
		}
	}
	public List<Category> getCatList(){
		return itemDao.getCatList();
	}
	public void saveItem(ItemDTO iDto) throws Exception{
		if(iDto!=null) {
			String path =serveletContext.getRealPath(UPLOAD_DIRECTORY);
			String filename = iDto.getFile().getOriginalFilename();
	        System.out.println(path+" "+filename);  

		try {
			byte[] bytes = iDto.getFile().getBytes();
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(
					new File(path+File.separator+filename)));
				out.write(bytes);
				out.flush();
				out.close();
		
			
		}catch(Exception e){
			throw e;
		}
		Item item =new Item(iDto.getName(),iDto.getQty(),iDto.getPrice(),filename,iDto.getCategory());
		itemDao.saveItem(item);
		}
	}
	public List<Item> getItemList(){
		return itemDao.getItemList();
	}
	public void savePurchase(PurchaseItem purchase) throws Exception{
		try {
			itemDao.savePurchase(purchase);
		}catch(Exception e){
			throw e;
		}
	}
	public List<PurchaseItem> getPurchaseItem(){
		return itemDao.getPurchaseItem();
	}
	public List<SaleItem> getSaleItem(){
		return itemDao.getSaleItem();
}
public void saveSale(SaleItem sale) {
try {
	itemDao.saveSale(sale);
	Item item=sale.getItem();
	int id=item.getId();
	itemDao.updateItemBySale(id, sale.getQty());
}catch(Exception ex) {
	ex.printStackTrace();
}	
	
}
}