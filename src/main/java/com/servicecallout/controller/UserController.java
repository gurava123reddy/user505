package com.servicecallout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicecallout.model.Comment;
import com.servicecallout.model.User;
import com.servicecallout.service.UserService;

@RestController
public class UserController {
	
	private UserService service;
	
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}


	@GetMapping("/users")
	public List<User> getUsers(){
		List<User> users = service.getUsers();
		return users;
	}
	
	@GetMapping("/comments")
	public List<Comment> getComments(){
		List<Comment> comments = service.getComments();
		return comments;
	}
}
