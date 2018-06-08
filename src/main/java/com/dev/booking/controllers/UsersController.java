package com.dev.booking.controllers;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dev.booking.models.User;
import com.dev.booking.repositories.UserRepository;


public class UsersController {
	
	@Autowired
    UserRepository userRepository;

    @GetMapping(value="/users")
    public Iterable<User> users() {
        return userRepository.findAll();
    }

    @PostMapping(value="/users")
    public ObjectId save(@RequestBody User user) {
    	userRepository.save(user);
        return user.getId();
    }

    @GetMapping(value="/users/{id}")
    public User show(@PathVariable ObjectId id) {
         Optional<User> user = userRepository.findById(id);
         return user.get();
    }

    @PutMapping(value="/products/{id}")
    public User update(@PathVariable ObjectId id, @RequestBody User user) {
        User userr = userRepository.findById(id).get();
            userr.setEmail(user.getEmail());        
            userr.setFirstName(user.getFirstName());       
            userr.setLastName(user.getLastName());
            userr.setLogin(user.getLogin());
            userr.setPassword(user.getPassword());
            userr.setRole(user.getRole());
        userRepository.save(userr);
        return userr;
    }

    @DeleteMapping(value="/users/{id}")
    public String delete(@PathVariable ObjectId id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return "user deleted";
    }

}
