package com.example.demo.business;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomeBusinessTest {

	@Test
	public void calculateSum_basic() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		int actualResult = impl.calculateSum(new int[]{1,2,3});
		assertEquals(6, actualResult);
	}

}
