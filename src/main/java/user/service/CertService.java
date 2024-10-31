package user.service;

import user.repository.UserDao;
import user.repository.UserDaoImpl;
import utils.Hash;
import user.dto.UserCert;
import user.entity.*;

public class CertService {
	private UserDao userDao=new UserDaoImpl();
	
	public UserCert getCert(String name,String password) {

		User user=userDao.getUserName(name);
		String passwordHash=Hash.getHash(password, user.getSalt());
		if(!user.getPasswordHash().equals(passwordHash)) {
			throw new RuntimeException("密碼錯誤");		
		}
		UserCert usercert=new UserCert(user.getUserId(), user.getUserName());
		
		return usercert;	
	}
}
