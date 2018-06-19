package com.dev.booking.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.booking.models.User;
import com.dev.booking.services.UserService;

@RestController
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/users")
	public Iterable<User> users() {
		return userService.getAll();
	}

	@PostMapping(value = "/users")
	public User save(@RequestBody User user) {
		return userService.save(user);
	}

	@GetMapping(value = "/users/{id}")
	public User read(@PathVariable ObjectId id) {
		return userService.read(id);
	}

	@PutMapping(value = "/users/{id}")
	public User update(@PathVariable ObjectId id, @RequestBody User user) {
		return userService.update(id, user);
	}

	@DeleteMapping(value = "/users/{id}")
	public String delete(@PathVariable ObjectId id) {
		userService.delete(id);
		return "user deleted";
	}

}
