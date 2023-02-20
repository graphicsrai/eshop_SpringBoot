package com.eshop.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.model.User;
import com.eshop.repo.UserRepo;
import com.eshop.service.UserService;

@Service
public class ServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> getallUser() {
		
		return userRepo.findAll();
	}

	@Override
	public String addUser(User user) {
		userRepo.save(user);
		return "Data has been saved";
	}

	@Override
	public String updateUser(int id, User user) {
		User u1=userRepo.findById(id).orElse(null);
		if(u1!=null)
		{
			u1.setUname(user.getUname());
			u1.setUemail(user.getUemail());
			u1.setPassword(user.getPassword());
			
			userRepo.save(u1);
		}
		
		return "Updated Successfuly";
	}

	@Override
	public String deleteUser(int id) {
		userRepo.deleteById(id);
		return "User has been deleted";
	}

	

}
