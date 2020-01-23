package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.business.ItemBusinessService;
import com.example.demo.model.Item;

@WebMvcTest(ItemController.class)
@RunWith(SpringRunner.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	

	@Test
	public void dummyItem_basic() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
									.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
								  .andExpect(status().isOk())
								  .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
								  .andReturn();
		
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}

	@Test
	public void ItemFromBusinessService() throws Exception {
		
		when(businessService.retrieveHardCodedItem()).thenReturn(new Item(1,"Ball",10,100));
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service")
									.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
								  .andExpect(status().isOk())
								  .andExpect(content().json("{id:1,name:Ball,price:10,quantity:100}"))
								  .andReturn();
		
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}
	
	@Test
	public void retrieveAllItems_basic() throws Exception {
		
		when(businessService.retrieveAllItems()).thenReturn(
				Arrays.asList(
						new Item(1,"Ball",10,100),
						new Item(2,"Pen",10,100)));
		
		
		RequestBuilder request = MockMvcRequestBuilders.get("/all-items-from-database")
									.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
								  .andExpect(status().isOk())
								  .andExpect(content().json("[{id:1,name:Ball,price:10,quantity:100},"
								  		+ "{id:2,name:Pen,price:10,quantity:100}]"))
								  .andReturn();
		
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}
}
