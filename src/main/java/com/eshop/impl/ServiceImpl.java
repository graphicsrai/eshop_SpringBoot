package com.eshop.impl;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.dto.UserDto;
import com.eshop.exception.BusinessException;
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
		List <User>l1=getallUser();
		
		
			for(User user1: l1)
			{
				if(user1.getUemail().equals(user.getUemail()))
				{
					throw new BusinessException("601","Email already exist");
				}
			}
		try {
			userRepo.save(user);
			
		}catch(Exception e)
		{
			throw new BusinessException("602","Something went wrong in Service layer"+e.getMessage());
			
		}
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

	@Override
	public String login(Map<String, String> map) {

		User user=userRepo.getByEmail(map.get("uemail"));
		if(map.get("uemail").equals(user.getUemail()))
		{
			if(map.get("password").equals(user.getPassword()))
			{
				return "Loging Successfull As "+ user.getUtype();
			}
			else
			{
				return "password doesnot match";
			}
		}
		else
		{
			return "UserName doesnot exist";
		}
		
	}

	

	

}
