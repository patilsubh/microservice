package com.seller.SellerInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seller.SellerInfo.model.SellerInfo;
import com.seller.service.SellerInfoService;

/**
 * Controller to operate on Seller
 * 
 * @author Admin
 *
 */
@RestController
@RequestMapping("/shopping")
public class SellerInfoController {
	@Autowired
	SellerInfoService sellerInfoService;

	/**
	 * Resource to get seller information list
	 * 
	 * @return
	 */
	@GetMapping("/seller")
	public List<SellerInfo> getSellerInfo() {
		return sellerInfoService.getAllSeller();

	}
}
