package com.spring.spring_intro.examples.a9;

import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MySqlDataService implements DataService {

	@Override
	public int[] retrieveData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}

}
