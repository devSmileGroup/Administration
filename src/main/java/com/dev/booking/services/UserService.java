package com.dev.booking.services;

import java.util.List;
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

	public Iterable<User> getAll() {
		List<User> listUser = (List<User>) userRepository.findAll();
		if(!listUser.isEmpty()) {
			return listUser;
		}
		return null;
	}

	public User save(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}

	public User read(@PathVariable ObjectId id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}

	public User update(@PathVariable ObjectId id, @RequestBody User user) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			User updatedUser = optionalUser.get();
			updatedUser.setEmail(user.getEmail());
			updatedUser.setFirstName(user.getFirstName());
			updatedUser.setLastName(user.getLastName());
			updatedUser.setLogin(user.getLogin());
			updatedUser.setPassword(user.getPassword());
			updatedUser.setRole(user.getRole());
			userRepository.save(updatedUser);
			return updatedUser;
		}
		return null;
	}

	public void delete(@PathVariable ObjectId id) {
		userRepository.deleteById(id);
	}

}
