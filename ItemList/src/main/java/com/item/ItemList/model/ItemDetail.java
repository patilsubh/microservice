package com.item.ItemList.model;

import java.io.Serializable;
/**
 * MOdel Class for Item Details
 * @author Admin
 *
 */
public class ItemDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Double price;
	private String description;
	private int productId;

	public ItemDetail() {

	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
