package com.seller.SellerInfo;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.seller.SellerInfo.controller.SellerInfoController;
import com.seller.SellerInfo.model.SellerInfo;
import com.seller.service.SellerInfoService;

@WebMvcTest(controllers = SellerInfoController.class)
@ActiveProfiles("test")
public class SellerApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private SellerInfoService sellerInfoService;
	@MockBean
	private RestTemplate restTemplate;

	private List<SellerInfo> sellerInfoList;

	@BeforeEach
	void setUp() {
		this.sellerInfoList = new ArrayList<SellerInfo>();
		SellerInfo sellerInfo = new SellerInfo();
		sellerInfo.setProductId(1);
		sellerInfo.setSellerName("Shell");
		sellerInfo.setSellerRating(5.0);
		this.sellerInfoList.add(sellerInfo);

	}

	@Test
	void shouldFetchAllSeller() throws Exception {

		given(sellerInfoService.getAllSeller()).willReturn(sellerInfoList);

		this.mockMvc.perform(get("/shopping/seller")).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(sellerInfoList.size())));
	}

}
