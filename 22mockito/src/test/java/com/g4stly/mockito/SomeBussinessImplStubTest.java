package com.g4stly.mockito;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBussinessImplStubTest {

	DataServiceStub dataServiceStub = new DataServiceStub();
	SomeBussinessImpl bussImpl = new SomeBussinessImpl(dataServiceStub);
	
	@Test
	void findTheGreatestFromAllData_basicScenario() {
		int result = bussImpl.findTheGreatestFromAllData();
		assertEquals(25, result);
	}

}

class DataServiceStub implements DataService{
	@Override
	public int[] retrieveAllData() {
		return new int[] {25,15,5};
	}
}

