package com.g4stly.junit;

import org.junit.jupiter.api.*;

class TestAnnotations {

	@Test
	void test1() {
		System.out.println("test1");
	}

	@Test
	void test2() {
		System.out.println("test2");
	}

	@Test
	void test3() {
		System.out.println("test3");
	}

	@BeforeEach //* before each test, this will run
	void beforeEach() {
		System.out.println("beforeEach");
	}
	
	@AfterEach //* after each test, this will run
	void afterEach() {
		System.out.println("afterEach");
	}
	
	/* so this is the test running queue: beforeEach, test1, afterEach, beforeEach, test2... */
	
	/** There are also: 
	 		static void beforeAll, 
	 		static void afterAll, 
	 	
	 	you can guess what they do
	*/
	
	
}

