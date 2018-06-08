package com.dev.booking.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import com.dev.booking.models.User;

public interface UserRepository extends CrudRepository<User,ObjectId>{

}
