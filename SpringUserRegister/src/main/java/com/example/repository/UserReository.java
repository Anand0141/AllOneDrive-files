package com.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Users;

@Repository
public interface UserReository extends MongoRepository<Users, Integer>{

	Optional<Users> findByEmail(String email);

}
