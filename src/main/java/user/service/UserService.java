package user.service;

import java.util.ArrayList;
import java.util.List;

import user.dto.UserDto;
import user.repository.*;
import user.entity.*;

public class UserService {
	
	UserDao userdao=new UserDaoImpl();
	
	public List<UserDto> findAll() {
		List<UserDto> userdtos= new ArrayList<UserDto>();
		List<User> users=userdao.findAllUser();
		for(User user:users) {
			UserDto usertemp=new UserDto();
			usertemp.setUserId(user.getUserId());
			usertemp.setUserName(user.getUserName());
			userdtos.add(usertemp);
		}
		return userdtos;
		
	}
	
	
	
	public UserDto getUser(String username) {
		
		UserDto userdto=new UserDto();
		User user=userdao.getUserName(username);
		
		userdto.setUserId(user.getUserId());
		userdto.setUserName(user.getUserName());	
		return userdto;
	
	}

}
