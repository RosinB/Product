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
		String sql="select user_id, user_name from user where user_name=?";
		try (PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, username);
			try(ResultSet rs=pstmt.executeQuery()) {
				while(rs.next()) {
					User user=new User();
					user.setUserId(rs.getInt("user_id"));
					user.setUserName(rs.getString("user_name"));
					
					return user;
				}
				
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return null;
	}

	
	
}
