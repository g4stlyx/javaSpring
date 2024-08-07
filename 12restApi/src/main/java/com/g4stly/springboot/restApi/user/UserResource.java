package com.g4stly.springboot.restApi.user;

import java.net.URI;
import java.util.List;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.g4stly.springboot.restApi.exception.UserNotFoundException;
import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	// entityModel olayı hateoas ile geldi, datayı düz user olarak değil, çeşitli linkler eklenmiş user olarak göndermeye yarıyor.
	@GetMapping("users/{id}")
	public EntityModel<User> retrieveOneUser(@PathVariable int id) {
		User user = service.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("id: "+id);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user);
		
		//WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).retrieveAllUsers());
		//entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id) {
		service.deleteById(id);
	}
	
	
}
