package com.item.ItemList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.item.ItemList.model.Item;
import com.item.ItemList.service.ItemListService;

/**
 * Controller Class for getting all item with seller information
 * 
 * @author Admin
 *
 */
@RestController
@RequestMapping("/shopping")
public class ItemListController {
	
	@Autowired
	ItemListService itemListService;
		
	/**
	 * Resource to get list of Item with Item detail and seller details
	 * 
	 * @return
	 */
	@GetMapping("/items")
	public List<Item> getItemList() {
		
		return itemListService.getAllItemList();

	}

}
