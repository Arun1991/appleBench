package com.example.demo.business;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.example.demo.data.SomeDataService;

public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		impl.setSomeDataService(new SomeDataServiceStub());
		int actualResult = impl.calculateSumUsingDataService();
		assertEquals(6, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_empty() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		impl.setSomeDataService(new SomeDataServiceStubEmpty());
		int actualResult = impl.calculateSumUsingDataService();
		assertEquals(0, actualResult);
	}
	
	@Test
	public void calculateSumUsingDataService_oneValue() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		impl.setSomeDataService(new SomeDataServiceStubOneValue());
		int actualResult = impl.calculateSumUsingDataService();
		assertEquals(5, actualResult);
	}

}
class SomeDataServiceStub implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[]{1,2,3};
	}
	
}
class SomeDataServiceStubEmpty implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[]{};
	}
	
}
class SomeDataServiceStubOneValue implements SomeDataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[]{5};
	}
	
}