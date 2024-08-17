package com.qspider.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qspider.springbootproject.entity.User;
import com.qspider.springbootproject.service.UserService;
import com.qspider.springbootproject.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService<User> service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
		
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<User>> find(@RequestParam int id) {
		return service.find(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<User>> deleteuser(@RequestParam int id) {
		return service.deleteById(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestParam int aid,@RequestParam int uid) {
		return service.assignAadhartoUser(aid, uid);
	}
	
	@GetMapping("all")
	public ResponseEntity<ResponseStructure<List<User>>> findAll() {
		return service.findAll();
	}

	@GetMapping("noadhar")
	public ResponseEntity<ResponseStructure<List<User>>> findAllWithNoAdhar() {
		return service.userWithNoAdhar();
	}
	
	@GetMapping("usergender")
	public ResponseEntity<ResponseStructure<List<User>>> findUserBygender(@RequestParam String gender) {
		return service.findUserBygender(gender);
	}
	}
