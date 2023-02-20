package com.eshop.mapper;

import java.util.List;

import com.eshop.dto.UserDto;
import com.eshop.model.User;

public interface UserMapper {
	List<UserDto> getAll(List<User> user);
	UserDto addDto(User user);
}
