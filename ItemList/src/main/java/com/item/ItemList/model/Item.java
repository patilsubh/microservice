package com.item.ItemList.model;

/**
 * Model class for Item
 * 
 * @author Admin
 *
 */
public class Item {

	private String name;
	private Double price;
	private String description;
	private String sellerName;
	private Double sellerRating;

	public Item(String name, Double price, String description, String sellerName, Double sellerRating) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.sellerName = sellerName;
		this.sellerRating = sellerRating;

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
