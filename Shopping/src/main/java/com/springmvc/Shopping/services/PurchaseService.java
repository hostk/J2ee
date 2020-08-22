package com.springmvc.Shopping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.Shopping.dao.ItemDao;
import com.springmvc.Shopping.model.Item;
import com.springmvc.Shopping.model.PurchaseItem;
import com.springmvc.Shopping.model.SaleItem;

@Service
@Transactional
public class PurchaseService {
	
	@Autowired
	ItemDao itemDao;
	
	public void savePurchase(PurchaseItem purchase) {
		try {
			itemDao.savePurchase(purchase);
			Item item=purchase.getItem();
			int id=item.getId();
			int qty=item.getQty();
			itemDao.getItemByAddQty(id, qty);
		}catch(Exception ex) {
			ex.printStackTrace();
		}	
	}
	
	public List<PurchaseItem> getPurchaseItem(){
				return itemDao.getPurchaseItem();
	}
	
	
	
}
