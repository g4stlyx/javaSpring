package com.g4stly.jpa.jpa_and_hibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g4stly.jpa.jpa_and_hibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course,Long>{
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
