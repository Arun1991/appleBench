package com.example.demo.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.data.ItemRepository;
import com.example.demo.data.SomeDataService;
import com.example.demo.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	ItemBusinessService businessService;
	
	@Mock
	ItemRepository repository;
	
	
	@Test
	public void retrieveAllItems() {
		when(repository.findAll()).thenReturn(
				Arrays.asList(
						new Item(1,"Ball",10,100),
						new Item(2,"Pen",10,5)));		
		List<Item> items = businessService.retrieveAllItems();
		assertEquals(1000,items.get(0).getValue());
		assertEquals(50,items.get(1).getValue());
	}
	
	
}
