package com.example.demo.spring.mongo.api.resourse;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.spring.mongo.api.model.Profile;
import com.example.demo.spring.mongo.api.repository.UserRepository;


@CrossOrigin(origins = "http://localhost:8888")
@RestController


public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
//---------------------------------------To get all users-------------------------------
@GetMapping("/alluser")
public List<Profile> getallusers(Profile profile) {
    return userRepository.findAll();
    }
	
//---------------------------------------To get a single User Dynamically-------------------------------
	@GetMapping("/singleuser/{id}")
	public Optional<Profile> getuserfromID(@PathVariable String id) {
		return userRepository.findById(id);
	}
	//--------------------------------To Add user --------------------------------------------------------
	@PostMapping("/adduser")
	public String createuser(@RequestBody Profile profile) {
	 userRepository.save(profile);
	 return "Added User with id :" + profile.getID();
	 
	}
	 
	//------------------------------------To update user------------------------------------------------
	@PutMapping("/updateuser/{id}")
	  public Profile updateTutorial(@PathVariable String id, @RequestBody Profile profile) {
		return userRepository.save(profile);	    
	  }

	//------------------------------------Delete a user---------------------------------------------------
	 @DeleteMapping("/deletesingleuser/{id}")
	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
		try {
			    userRepository.deleteById(id);
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
	  }
	 
	 @DeleteMapping("/deleteallusers")
	  public ResponseEntity<HttpStatus> deleteTutorial(){
		 try {
			    userRepository.deleteAll();
			    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  } catch (Exception e) {
			    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			  }
		 }
	 
}
