package com.code.spring.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.code.spring.dao.UserDAO;
import com.code.spring.model.User;

@Repository
@Transactional
public class UserDAOImplHib implements UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);	
	}

	@Override
	public User save(User user) {
		sessionFactory.getCurrentSession().update(user);
        return user;
		
	}

	@Override
	public void delete(int userId) {
		User user = (User) sessionFactory.getCurrentSession().load(
				User.class, userId);
        if (null != user) {
            this.sessionFactory.getCurrentSession().delete(user);
        }
	}

	@Override
	public User get(int userId) {
		 return (User) sessionFactory.getCurrentSession().get(
				 User.class, userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User")
                .list();
	}

}
