package com.g4stly.jpa.jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.g4stly.jpa.jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;


@Component
public class CourseCommandLineRunner implements CommandLineRunner{

//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired 
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// for jdbc and jpa
		//repository.insert(new Course(1,"Learn AWS","g4"));
		//repository.insert(new Course(2,"Learn Docker","g4"));
		//repository.insert(new Course(3,"Learn Spring Security","g4"));
		
		//repository.deleteById(2);

		//System.out.println(repository.findById(1));
		//System.out.println(repository.findById(3));
	
		//for spring data jpa
		repository.save(new Course(1,"Learn AWS","g4"));
		repository.save(new Course(2,"Learn Docker","g4"));
		repository.save(new Course(3,"Learn Spring Security","g4"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(1l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("g4"));
		System.out.println(repository.findByName("Learn AWS"));
		
	}
	
}
