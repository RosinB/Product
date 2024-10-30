package user.entity;

import lombok.Data;

@Data
public class User {
	private Integer userId;
	private String  userName;
	private String  passwordHash;
	private String  salt;
	

	
	
}
