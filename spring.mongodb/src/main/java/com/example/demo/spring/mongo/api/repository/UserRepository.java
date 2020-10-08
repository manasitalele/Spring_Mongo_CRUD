package com.example.demo.spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.spring.mongo.api.model.Profile;

public interface UserRepository extends MongoRepository<Profile, String> {

	ResponseEntity<HttpStatus> deleteById();
	

}
