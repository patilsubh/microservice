package com.ItemDetail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ItemDetail.model.ItemDetail;
import com.ItemDetail.service.ItemDetailService;

/**
 * Controller class to get Item Detail available in database
 * 
 * @author Admin
 *
 */
@RestController
@RequestMapping("/shopping")
public class ItemDetailController {
	@Autowired
	ItemDetailService itemDetailService;

	/**
	 * Resource for getting all Item available.
	 * @return
	 */
	@GetMapping("/item")
	public List<ItemDetail> getItemDetail() {
		return itemDetailService.getAllItem();

	}
}
