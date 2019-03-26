package com.code.spring.dao;

import java.util.List;

import com.code.spring.model.User;

public interface UserDAO {
	
	public void create(User user);
	
	public User save(User user);
    
    public void delete(int userId);
     
    public User get(int userId);
     
    public List<User> list();
}
