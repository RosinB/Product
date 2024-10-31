package user.repository;

import java.util.List;

import user.entity.User;

public interface UserDao {
	
	List<User> findAllUser();
	
	User getUserName(String username);
	
	void addUserName(User user);
	
	void updatePassword(Integer userId,String newPasswordHash);

}
