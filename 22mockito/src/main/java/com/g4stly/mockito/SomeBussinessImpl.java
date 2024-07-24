package com.g4stly.mockito;

public class SomeBussinessImpl {

	private DataService dataService;
	
	public SomeBussinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findTheGreatestFromAllData() {
		
		int[] data = dataService.retrieveAllData();
		int greatestValue = Integer.MIN_VALUE;
		for(int value:data) {
			if(value > greatestValue) {
				greatestValue = value;
			}
		}
		return greatestValue;
	}

}

interface DataService{
	int[] retrieveAllData();
}