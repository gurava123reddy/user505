package com.servicecallout.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.servicecallout.model.Comment;
import com.servicecallout.model.CommentList;
import com.servicecallout.model.Post;
import com.servicecallout.model.PostList;
import com.servicecallout.model.ToDos;
import com.servicecallout.model.ToDosList;
import com.servicecallout.model.User;
import com.servicecallout.model.UserList;

@Service
public class UserServiceImpl implements UserService {
	
	

	@Override
	public List<User> getUsers() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url1 = "https://gorest.co.in/public/v1/users";
		String url2 = "https://gorest.co.in/public/v1/posts";
		String url3 = "https://gorest.co.in/public/v1/comments";
		String url4 = "https://gorest.co.in/public/v1/todos";
		
		ResponseEntity<UserList> response1 = restTemplate.getForEntity(url1, UserList.class);
		List<User> users = response1.getBody().getData();
		
		
		  ResponseEntity<PostList> response2 = restTemplate.getForEntity(url2,
		  PostList.class); List<Post> posts = response2.getBody().getData();
		  
		  ResponseEntity<CommentList> response3 = restTemplate.getForEntity(url3,
		  CommentList.class); List<Comment> comments = response3.getBody().getData();
		  
		  ResponseEntity<ToDosList> response4 = restTemplate.getForEntity(url4,
		  ToDosList.class); List<ToDos> todos = response4.getBody().getData();
		  
		  for(ToDos t: todos) { for(Comment c: comments) { for(Post p: posts) {
		  for(User u: users) { if(t.getUser_id()==c.getId()) { c.setTodos(t); }
		  if(c.getPost_id()==p.getId()) { p.setComment(c); }
		  if(p.getUser_id()==u.getId()) { u.setPost(p); } } } } }
		 
		return users;
	}

	@Override
	public List<Comment> getComments() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url3 = "https://gorest.co.in/public/v1/comments";
		
		ResponseEntity<CommentList> response = restTemplate.getForEntity(url3, CommentList.class);
		List<Comment> comments = response.getBody().getData();
		return comments;
	}

	
}
