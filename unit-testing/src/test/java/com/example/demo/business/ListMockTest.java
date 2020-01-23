package com.example.demo.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static  org.mockito.Mockito.mock;

public class ListMockTest {

	List<String> mock =  mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValue() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	@Test
	public void returnWithParametres(){
		when(mock.get(0)).thenReturn("in 28 minutes");
		assertEquals("in 28 minutes", mock.get(0));
	}
	
	@Test
	public void returnWithGenericParametres(){
		when(mock.get(anyInt())).thenReturn("in 28 minutes");
		assertEquals("in 28 minutes", mock.get(0));
		assertEquals("in 28 minutes", mock.get(5));
	}
	@Test
	public void verificationBasics(){
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		//verify whether get method is called or not
		verify(mock).get(0);
		verify(mock,times(2)).get(anyInt());
		verify(mock,atLeast(1)).get(anyInt());
		verify(mock,atLeastOnce()).get(anyInt());
		verify(mock,atMost(2)).get(anyInt());
		verify(mock,never()).get(2);
	}
	
	@Test
	public void argumentCapturing(){
		mock.add("SomeString");
		
		ArgumentCaptor<String>captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		assertEquals("SomeString", captor.getValue());
	}
	
	@Test
	public void multipleArgumentCapturing(){
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		ArgumentCaptor<String>captor = ArgumentCaptor.forClass(String.class);
		verify(mock,times(2)).add(captor.capture());
		List<String> allValues = captor.getAllValues();
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
	}
	
	@Test
	public void mocking(){
		ArrayList< String> arraylistMock = mock(ArrayList.class);
		System.out.println(arraylistMock.get(0));//null
		System.out.println(arraylistMock.size());//0
		arraylistMock.add("Test");
		arraylistMock.add("Test2");
		System.out.println(arraylistMock.size());//0
		when(arraylistMock.size()).thenReturn(5);
		System.out.println(arraylistMock.size());//5
	}

	@Test
	public void spying(){
		ArrayList< String> arraylistSpy = spy(ArrayList.class);
		arraylistSpy.add("Test0");
		System.out.println(arraylistSpy.get(0));//Test0
		System.out.println(arraylistSpy.size());//1
		arraylistSpy.add("Test");
		arraylistSpy.add("Test2");
		System.out.println(arraylistSpy.size());//3
		when(arraylistSpy.size()).thenReturn(5);
		System.out.println(arraylistSpy.size());//5
	}
}








