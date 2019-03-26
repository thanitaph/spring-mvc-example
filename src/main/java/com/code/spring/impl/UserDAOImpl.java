package com.code.spring.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.code.spring.dao.UserDAO;
import com.code.spring.model.User;


public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserDAOImpl() {
		
	}
	 
    public UserDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public void create(User user) {
		String sql = "INSERT INTO user (userName, userAge)"
                + " VALUES (?, ?)";
		jdbcTemplate.update(sql, user.getUserName(), user.getUserAge());
		
	}

	@Override
	public User save(User user) {
		return user;
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(int userId) {
		String sql = "SELECT * FROM user WHERE id=?";
		
		@SuppressWarnings("unchecked")
		User getUser = (User) jdbcTemplate.queryForObject(sql, new Object[] { userId }, new BeanPropertyRowMapper<User>(User.class));
		
		return getUser;
	}

	@Override
	public List<User> list() {
		String sqlQuery = "SELECT * FROM user";
		
		 List<User> listUser = jdbcTemplate.query(sqlQuery, new RowMapper<User>() {
			 
		        @Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	User user = new User();

		        	user.setId(rs.getInt("id"));
		        	user.setUserName(rs.getString("userName"));
		        	user.setUserAge(rs.getString("userAge"));
		            return user;
		        }
		 
		    });
		return listUser;
	}

}
