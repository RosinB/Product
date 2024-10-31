package user.dto;

public class UserCert {
	private Integer userId;
	private String  userName;
	private String  passwordHash;
	private String  salt;
	public UserCert(Integer userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "UserCert [userId=" + userId + ", userName=" + userName + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserId() {
		return userId;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public String getSalt() {
		return salt;
	}
	
	
}