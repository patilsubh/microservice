package com.ItemDetail.ItemDetail;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.ItemDetail.controller.ItemDetailController;
import com.ItemDetail.model.ItemDetail;
import com.ItemDetail.service.ItemDetailService;

@WebMvcTest(controllers = ItemDetailController.class)
@ActiveProfiles("test")
public class ItemDetailApplicationTests {

	private MockMvc mockMvc;

	@MockBean
	private ItemDetailService itemDetailService;
	@MockBean
	private RestTemplate restTemplate;

	private List<ItemDetail> itemDetailList;

	@BeforeEach
	void setUp() {
		this.itemDetailList = new ArrayList<ItemDetail>();
		ItemDetail itemDetail = new ItemDetail();
		itemDetail.setProductId(1);
		itemDetail.setName("petrol");
		itemDetail.setPrice(12d);
		itemDetail.setDescription("very good product");
		this.itemDetailList.add(itemDetail);

	}
	
	@Test
	void shouldFetchAllItemDetail() throws Exception {

		given(itemDetailService.getAllItem()).willReturn(itemDetailList);

		this.mockMvc.perform(get("/shopping/item")).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(itemDetailList.size())));
	}
}
