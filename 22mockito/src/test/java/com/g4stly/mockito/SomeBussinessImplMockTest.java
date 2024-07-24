package com.g4stly.mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBussinessImplMockTest {

	@Mock
	private DataService dataServiceMock;
	
	@InjectMocks
	private SomeBussinessImpl bussImpl;
	
	@Test
	void findTheGreatestFromAllData_basicScenario() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,15,5});
		assertEquals(25, bussImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void findTheGreatestFromAllData_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {35});
		assertEquals(35, bussImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void findTheGreatestFromAllData_emptyArray() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, bussImpl.findTheGreatestFromAllData());
	}

}

