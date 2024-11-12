package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin
public class Service {

	@Autowired
	DAO dao;
	
	@GetMapping("/")
	public String initial()
	{
		return "This is Home Page";
	}
	@PostMapping("/user")
	public String insertUser(@RequestBody User user) {
		dao.insert(user);
		return "User Inserted";
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) {
		User u=dao.findUser(user.getEmail());
		if(u==null)
		{
			System.out.println("user2 is null");
			return user;
		}
		else if(user.password.equals(u.password) )
		{
			System.out.println("password is correct");
			return u;
		}
		System.out.println("password is wrong");
		return user;
	}
	
	
}
