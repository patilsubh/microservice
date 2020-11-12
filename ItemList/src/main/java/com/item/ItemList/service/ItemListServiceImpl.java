package com.item.ItemList.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.item.ItemList.model.Item;
import com.item.ItemList.model.ItemDetail;
import com.item.ItemList.model.SellerInfo;

/**
 * Service class to operate on Item list
 * 
 * @author Admin
 *
 */
@Component
public class ItemListServiceImpl implements ItemListService {
	@Autowired
	RestTemplate restTemplate;

	/**
	 * Method to call Item detail service and seller information service and
	 * combined both list to generate item list
	 */
	@Override
	public List<Item> getAllItemList() {
		ResponseEntity<List<ItemDetail>> itemDetailList = restTemplate.exchange(
				"http://ITEMDETAIL-SERVICE/shopping/item", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ItemDetail>>() {
				});

		ResponseEntity<List<SellerInfo>> sellerInfoList = restTemplate.exchange(
				"http://SELLERINFO-SERVICE/shopping/seller", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<SellerInfo>>() {
				});

		List<Item> items = new ArrayList<Item>();
		if (null != itemDetailList && null != sellerInfoList) {

			for (ItemDetail itemDetail : itemDetailList.getBody()) {

				for (SellerInfo sellerInfo : sellerInfoList.getBody()) {
					if (itemDetail.getProductId() == sellerInfo.getProductId()) {
						Item item = new Item(itemDetail.getName(), itemDetail.getPrice(), itemDetail.getDescription(),
								sellerInfo.getSellerName(), sellerInfo.getSellerRating());
						items.add(item);
					}
				}
			}
		}
		return items;
	}

}
