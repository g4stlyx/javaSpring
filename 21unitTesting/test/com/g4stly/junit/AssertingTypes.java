package com.g4stly.junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class AssertingTypes {

	String[] todos = new String[] {"AWS", "Azure", "DevOps"};
	List<String> todosList = Arrays.asList(todos);
	
	
	@Test
	void test() {
		boolean test = todosList.contains("AWS");
		
		assertEquals(true, test, "The array doesnt contain the value needed.");
		assertTrue(test, "The array doesnt contain the value needed.");
		assertFalse(!test, "these 3 do the same thing");
		
		//assertNull(todosList);
		assertNotNull(todosList);
		
		String[] testArray = new String[] {"AWS","Azure","DevOps"};
		assertArrayEquals(testArray, todos);
		
		assertEquals(3, todosList.size(), "Array doesnt have exactly 3 values.");
	}

}
