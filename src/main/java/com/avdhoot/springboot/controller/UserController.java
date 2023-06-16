package com.avdhoot.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.avdhoot.springboot.model.RequestModel;
import com.avdhoot.springboot.model.ResponseModel;
import com.avdhoot.springboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/new")
	public ResponseModel addUsers(@RequestBody RequestModel model) {
		return service.addUsers(model);
	}

	@GetMapping("/user")
	public List<RequestModel> getUsers() {
		return service.getUsers();

	}

	@GetMapping("/user/{id}")
	public RequestModel getUserById(@PathVariable("id") int id) {
		return service.getUserById(id);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseModel deleteUserById(@PathVariable("id") int id) {
		return service.deleteUserById(id);
	}
	
	@PutMapping("/user/{id}")
	public ResponseModel updateUserById(@PathVariable("id") int id, @RequestBody RequestModel model) {
		return service.updateUserById(id, model);
	}
}
