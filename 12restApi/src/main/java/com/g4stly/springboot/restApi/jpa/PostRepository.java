package com.g4stly.springboot.restApi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.g4stly.springboot.restApi.user.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {
	
}
