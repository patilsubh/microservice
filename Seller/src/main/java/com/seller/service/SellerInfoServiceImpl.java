package com.seller.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.seller.SellerInfo.model.SellerInfo;

/**
 * Service class for operating on Seller entity
 * @author Admin
 *
 */
@Component
public class SellerInfoServiceImpl implements SellerInfoService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	/**
	 * Service method to all seller available in databse
	 */
	@Override
	public List<SellerInfo> getAllSeller() {
		return jdbcTemplate.query("select * from sellerinfo", (resultSet, i) -> {
			return toSellerInfo(resultSet);
		});
	}

	private SellerInfo toSellerInfo(ResultSet resultSet) {
		SellerInfo info = new SellerInfo();
		try {
			info.setProductId(resultSet.getInt("product_Id"));
			info.setSellerName(resultSet.getString("seller_name"));
			info.setSellerRating(resultSet.getDouble("seller_rating"));
			
			return info;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return info;
	}

}
