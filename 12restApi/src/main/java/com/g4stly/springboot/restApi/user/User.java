package com.g4stly.springboot.restApi.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity(name="users")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=3,max=15,message="Name must be between 3 and 15 characters long.")
	@JsonProperty("user_name") // to change the json property "name" as "user_name"
	private String name;
	
	@Past(message="Birth date cannot be in the future, please enter a valid birth date.")
	@JsonProperty("birth_date")
	private LocalDate birthDate;
	
	@OneToMany(mappedBy= "user") // =one user can multiple posts
	// @JsonIgnore
	private List<Post> posts;

	public User(){}
	
	public User(int id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
}
