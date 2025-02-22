package com.vs.main.dao;
import com.vs.main.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	 private JdbcTemplate jdbcTemplate;
//	-------------------Insertion--------------------
	public boolean insertUser(User user) {
		
		boolean status=false;
		
		try {	
			String insertQuery="INSERT INTO user(name,email,gender,city) VALUES (?,?,?,?)";
				int count=jdbcTemplate.update(insertQuery, user.getName(),user.getEmail(),user.getGender(),user.getCity());
		
		if (count>0) {
			status=true;
			
		}
		else {
			status=false;
		}
		
		}catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		
		return status;
	}
//	----------------Updation--------------
	
	public boolean updateUser(User user) {
		
		boolean status=false;
		
		try {
			String updateQuery="UPDATE user SET name=?,gender=?,city=? WHERE email=?";
			int count=jdbcTemplate.update(updateQuery, user.getName(),user.getGender(),user.getCity(),user.getEmail());
			if (count>0) {
				status=true;
			} else {
				status=false;
			}
			
			
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		
		return status;
	}
	
	
//	----------------Deletion--------------
	
	public boolean deleteUserByEmailId(String email) {
		
		boolean status=false;
		
		try {
			String deleteQuery="DELETE FROM user WHERE email=?";
			int count=jdbcTemplate.update(deleteQuery,email);
			if (count>0) {
				status=true;
			} else {
				status=false;
			}
			
			
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		
		return status;
	}
	
	public User getUserByEmail(String email) {
		
		  String selectQuery="SELECT * FROM user  WHERE email=?";
		  return jdbcTemplate.queryForObject(selectQuery, new UserRowMapper(), email);
		  
	  }
	
	public List<User> getListOfUser() {
		
		String selectListQueryString="SELECT * FROM user";
		return jdbcTemplate.query(selectListQueryString, new UserRowMapper());
		
	}
	public final class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user=new User();
			user.setName(rs.getString("name"));
			user.setEmail(rs.getNString("email"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));
			return user;
		}
		
	}
}
