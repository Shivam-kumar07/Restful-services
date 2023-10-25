package com.learnspring.webservices.restfulservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	@Autowired
	UserDaoService service;

	@GetMapping("users")
	public List getAllUsers() {
		return service.findAll();
	}

	@GetMapping("users/{id}")
	public User getOneUser(@PathVariable int id) {
		User user= service.findOne(id);
		if (user==null) {
			throw new UserNotFoundException("id : "+ id+ " not foundd");
		}
		return user;

	}

	@PostMapping("users")
	//@Valid is used to check validation on User class
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("users/{id}")
	public void deleteOneUser(@PathVariable int id) {
		User user= service.deleteById(id);
		if (user==null) {
			throw new UserNotFoundException("id : "+ id+ " not found");
		}
	}

}
