package com.leysoft.hsproject.repository.implem;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leysoft.hsproject.entity.User;
import com.leysoft.hsproject.repository.interf.UserRepository;

@Repository("userRepository")
public class UserRepositoryImp implements UserRepository {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(User user) {
		user.setEnable(true);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	
	@Override
	public User findById(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id); 
	}
	
	@Override
	public User findByUsername(String username) {
		return (User) sessionFactory.getCurrentSession()
				.createQuery("from User as u where u.username = :name")
				.setParameter("name", username).uniqueResult();
	}
	
	@Override
	public User findByEmail(String email) {
		return (User) sessionFactory.getCurrentSession()
				.createQuery("from User as u where u.email = :email")
				.setParameter("email", email).uniqueResult();
	}
	
	@Override
	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}
	
	@Override
	public void disable(int id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		if(user != null && user.isEnable()) {
			user.setEnable(false);
			sessionFactory.getCurrentSession().update(user);
		}
	}
}
