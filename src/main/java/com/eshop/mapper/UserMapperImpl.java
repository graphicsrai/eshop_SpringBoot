package com.eshop.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.eshop.dto.UserDto;
import com.eshop.model.User;
@Component
public class UserMapperImpl implements UserMapper{

	@Override
	public List<UserDto> getAll(List<User> user) {
		List<UserDto> l1=new ArrayList<UserDto>();
		for(User u1: user)
		{
			l1.add(addDto(u1));
		}
		return l1;
	}

	@Override
	public UserDto addDto(User user) {
		UserDto d1=new UserDto();
		d1.setUemail(user.getUemail());
		d1.setUname(user.getUname());
		d1.setUtype(user.getUtype());
		return d1;
	}

}
