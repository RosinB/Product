package user.service;

import java.util.ArrayList;
import java.util.List;

import user.dto.UserDto;
import user.repository.*;
import utils.Hash;
import user.entity.*;

public class UserService {
	
	UserDao userdao=new UserDaoImpl();

	//	查全部
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
	
	
//	查單筆
	public UserDto getUser(String username) {
		
		UserDto userdto=new UserDto();
		User user=userdao.getUserName(username);
		
		userdto.setUserId(user.getUserId());
		userdto.setUserName(user.getUserName());	
		return userdto;
	
	}
/// 改密碼 
	public void updatePassword(Integer userId,String userName,String oldPassword,String newPassWord) {
		User user=userdao.getUserName(userName);
		if(user==null) {
			
			throw new RuntimeException("user為空");
		}
		if(!Hash.getHash(oldPassword, user.getSalt()).equals(user.getPasswordHash())) {
			throw new RuntimeException("原密碼輸入錯誤");
		}
		userdao.updatePassword(userId, Hash.getHash(newPassWord, user.getSalt()));
		
	}
	
	
}
