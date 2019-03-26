package com.code.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.code.spring.dao.UserDAO;
import com.code.spring.model.User;

@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	@Qualifier("userDAOHiber")
	private UserDAO userDao;

	@Override
	@Transactional
	public void create(User user) {
		userDao.create(user);
	}

	@Override
	public User save(User user) {
		return userDao.save(user);
	}

	@Override
	@Transactional
	public void delete(int userId) {
		userDao.delete(userId);
		
	}

	@Override
	public User get(int userId) {
		return userDao.get(userId);
	}

	@Override
	@Transactional
	public List<User> list() {
		return userDao.list();
	}

}
