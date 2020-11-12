package com.ItemDetail.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ItemDetail.model.ItemDetail;
/**
 * Service class to query database to get Iteam detail
 * @author Admin
 *
 */
@Component
public class ItemDetailServiceImpl implements ItemDetailService {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ItemDetail> getAllItem() {
		return jdbcTemplate.query("select * from itemdetail", (resultSet, i) -> {
			return toItemDetail(resultSet);
		});
	}

	private ItemDetail toItemDetail(ResultSet resultSet) {

		try {

			ItemDetail itemDetail = new ItemDetail();
			itemDetail.setName(resultSet.getString("name"));
			itemDetail.setDescription(resultSet.getString("decription"));
			itemDetail.setPrice(resultSet.getDouble("price"));
			itemDetail.setProductId(resultSet.getInt("id"));
			/*
			 * Ite new ItemDetail(resultSet.getString("name"), resultSet.getDouble("price"),
			 * resultSet.getString("decription"),resultSet.getInt("id"));
			 */
			 return itemDetail;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}
}
