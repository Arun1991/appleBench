package com.example.demo.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl impl;
	
	@Mock
	SomeDataService dataServiceMock;
	//SomeDataService dataServiceMock = mock(SomeDataService.class);

	
	/*
	@Before//in junit4
	//@BeforeEach // in junit5
	public void before(){
		impl.setSomeDataService(dataServiceMock);
		
	}*/
	
	@Test
	public void calculateSumUsingDataService() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{1,2,3});		
		int actualResult = impl.calculateSumUsingDataService();
		assertEquals(6, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
		int actualResult = impl.calculateSumUsingDataService();
		assertEquals(0, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
		int actualResult = impl.calculateSumUsingDataService();
		assertEquals(5, actualResult);
	}

}
