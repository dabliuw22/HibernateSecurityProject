package com.leysoft.hsproject.repository.interf;

import com.leysoft.hsproject.entity.User;

public interface UserRepository {
	
	public void save(User user);
	
	public User findById(int id);
	
	public User findByUsername(String username);
	
	public User findByEmail(String email);
	
	public void update(User user);
	
	public void disable(int id);
}
