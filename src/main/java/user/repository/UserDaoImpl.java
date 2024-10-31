package user.repository;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.entity.User;

import shopping.repository.BaseDao;


public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public List<User> findAllUser() {
		String sql="select user_id,user_name from user";
		List<User> user=new ArrayList<User>();
		try(Statement stmt=conn.createStatement(); 
			ResultSet rs=stmt.executeQuery(sql))
		{	while(rs.next()) {
			User users=new User();
			users.setUserId(rs.getInt("user_id"));
			users.setUserName(rs.getString("user_name"));
			user.add(users);	
		}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;

		
	}

	@Override
	public User getUserName(String username) {
		String sql="select user_id, user_name ,password_hash,salt from user where user_name=?";
		try (PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, username);
			try(ResultSet rs=pstmt.executeQuery()) {
				while(rs.next()) {
					User user=new User();
					user.setUserId(rs.getInt("user_id"));
					user.setUserName(rs.getString("user_name"));
					user.setPasswordHash(rs.getString("password_hash"));
					user.setSalt(rs.getString("salt"));
					return user;
				}
				
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return null;
	}

	@Override
	public void updatePassword(Integer userId, String newPasswordHash) {
		String sql = " update user set password_hash=? where user_id=?";
		try(PreparedStatement pstmt =conn.prepareStatement(sql)) {
			pstmt.setString(1,newPasswordHash);
			pstmt.setInt(2, userId);
			pstmt.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
		
		
		
	}

	
	
}
