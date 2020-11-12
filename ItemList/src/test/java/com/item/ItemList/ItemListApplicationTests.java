package com.item.ItemList;

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

import com.item.ItemList.controller.ItemListController;
import com.item.ItemList.model.Item;
import com.item.ItemList.service.ItemListService;

@WebMvcTest(controllers = ItemListController.class)
@ActiveProfiles("test")
public class ItemListApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemListService itemListService;
	@MockBean
	private RestTemplate restTemplate;
	

	private List<Item> itemList;

	@BeforeEach
	void setUp() {
		this.itemList = new ArrayList<Item>();
		this.itemList.add(new Item("petrol", 24.0, "This is Petrol", "Shell", 5.0));
		this.itemList.add(new Item("car", 24.0, "This is car", "merc", 5.0));
		
	}

	@Test
	void shouldFetchAllItems() throws Exception {

		given(itemListService.getAllItemList()).willReturn(itemList);

		this.mockMvc.perform(get("/shopping/items")).andExpect(status().isOk())
				.andExpect(jsonPath("$.size()", is(itemList.size())));
	}
	
	

}
