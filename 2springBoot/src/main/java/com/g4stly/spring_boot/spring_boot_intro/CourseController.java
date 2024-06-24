package com.g4stly.spring_boot.spring_boot_intro;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(
			new Course(1, "Learning Spring Boot", "g4stly"),
			new Course(2, "Learn AWS", "g4"),
			new Course(3, "Learn Spring Security", "g4")
				);
	}
	
}
