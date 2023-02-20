package com.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.impl.ServiceImpl;
import com.eshop.model.User;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class Controller {
	@Autowired
	private ServiceImpl serviceImpl;
	
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "Its working";
	}
	
	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody User user)
	{
		String msg=serviceImpl.addUser(user);
		if(msg!=null) {
			return ResponseEntity.status(200).body(msg);
		}
		else
		{
			return ResponseEntity.status(400).body(msg);
		}
	}
	
	@GetMapping
	public ResponseEntity <List<User>> getAllUsers()
	{
		List<User> l1= serviceImpl.getallUser();
		if(l1!=null)
		{
			return ResponseEntity.status(200).body(l1);
		}
		else
		{
			return ResponseEntity.status(400).body(l1);
		}
	}
	@PutMapping
	public ResponseEntity <String> updateUser(@RequestHeader int id,@RequestBody User user)
	{
		String msg= serviceImpl.updateUser(id,user);
		if(msg!=null)
		{
			return ResponseEntity.status(200).body(msg);
		}
		else
		{
			return ResponseEntity.status(400).body(msg);
		}
	}
	@DeleteMapping
	public ResponseEntity <String> deleteUser(@RequestHeader int id)
	{
		String msg= serviceImpl.deleteUser(id);
		if(msg!=null)
		{
			return ResponseEntity.status(200).body(msg);
		}
		else
		{
			return ResponseEntity.status(400).body(msg);
		}
	}
	
}
