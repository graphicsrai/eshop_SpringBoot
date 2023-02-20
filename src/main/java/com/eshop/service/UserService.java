package com.eshop.service;

import java.util.List;

import com.eshop.dto.UserDto;
import com.eshop.model.User;

public interface UserService {
	
	List<User> getallUser();
	
	String addUser(User user);
	
	String updateUser(int id,User user);
	
	String deleteUser(int id);
	
}
