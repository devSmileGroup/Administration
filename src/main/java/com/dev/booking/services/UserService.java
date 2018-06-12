package com.dev.booking.services;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dev.booking.models.User;
import com.dev.booking.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	public Iterable<User>getAll() {
		return userRepository.findAll();
	}
	
	public User save(@RequestBody User user) {
    	userRepository.save(user);
        return user;
    }
	
	public User show(@PathVariable ObjectId id) {
        Optional<User> showedUser = userRepository.findById(id);
        return showedUser.get();
	}
	
	public User update(@PathVariable ObjectId id, @RequestBody User user) {
        User updatedUser = userRepository.findById(id).get();
            updatedUser.setEmail(user.getEmail());        
            updatedUser.setFirstName(user.getFirstName());       
            updatedUser.setLastName(user.getLastName());
            updatedUser.setLogin(user.getLogin());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setRole(user.getRole());
        userRepository.save(updatedUser);
        return updatedUser;
    }
	
	public String delete(@PathVariable ObjectId id) {
        User deletedUser = userRepository.findById(id).get();
        userRepository.delete(deletedUser);
        return "user deleted";
    }

}
