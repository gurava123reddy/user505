package com.servicecallout.service;

import java.util.List;

import com.servicecallout.model.Comment;
import com.servicecallout.model.User;

public interface UserService {

	public List<User> getUsers();
	public List<Comment> getComments();
}
