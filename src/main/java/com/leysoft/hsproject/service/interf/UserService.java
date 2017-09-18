package com.leysoft.hsproject.service.interf;

import com.leysoft.hsproject.entity.User;

public interface UserService {
	
	public void save(User user);
	
	public User findById(int id);
	
	public User findByUsername(String username);
	
	public void update(User user);
	
	public void disable(int id);
	
	public boolean isUniqueUsername(String username);
	
	public boolean isUniqueEmail(String email);
}
