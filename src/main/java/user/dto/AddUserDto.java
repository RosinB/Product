package user.dto;

import lombok.Data;

@Data
public class AddUserDto {
	private Integer userId;
	private String  userName;
	private String  passwordHash;
	private String  salt;


	
	
}