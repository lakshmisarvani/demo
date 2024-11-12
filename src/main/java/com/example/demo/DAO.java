package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class DAO {

	@Autowired
	UserInterface repo;
	public void insert(User u1)
	{
		repo.save(u1);
	}
	public User findUser(String email) {
		return repo.findByEmail(email);
	}
	
}
