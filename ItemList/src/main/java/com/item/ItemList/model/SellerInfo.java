package com.item.ItemList.model;

import java.io.Serializable;

/**
 * Model class for Seller information
 * 
 * @author Admin
 *
 */
public class SellerInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String sellerName;
	private Double sellerRating;
	private int productId;

	public SellerInfo() {

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Double getSellerRating() {
		return sellerRating;
	}

	public void setSellerRating(Double sellerRating) {
		this.sellerRating = sellerRating;
	}

}
