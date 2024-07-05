package com.g4stly.springboot.restApi.user;

import jakarta.persistence.*;

@Entity(name="posts")
public class Post {

	@Id
	@GeneratedValue
	private int id;
	
	private String description;
	
	@ManyToOne // (fetch= FetchType.LAZY) // multiple posts can be owned by one user
	// (fetch = FetchType.LAZY) = i dont want user to be seen when fetching posts
	// @JsonIgnore
	private User user;
	

	public Post(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}
	
}
