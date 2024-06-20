package com.spring.spring_intro.examples.a9;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Primary
public class MongoDbDataService implements DataService {

	@Override
	public int[] retrieveData() {
		return new int[] { 11, 22, 33, 44, 55 };
	}

}
