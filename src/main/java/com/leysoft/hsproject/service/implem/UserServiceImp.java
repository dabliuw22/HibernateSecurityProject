package com.leysoft.hsproject.service.implem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leysoft.hsproject.entity.User;
import com.leysoft.hsproject.repository.interf.UserRepository;
import com.leysoft.hsproject.service.interf.UserService;

@Service("userService") @Transactional
public class UserServiceImp implements UserService {
	
	@Autowired @Qualifier("userRepository")
	private UserRepository userRepository;
	
	
	
	@Transactional
	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Transactional(readOnly = true)
	@Override
	public User findById(int id) {
		return userRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Transactional
	@Override
	public void update(User user) {
		userRepository.update(user);
	}

	@Transactional
	@Override
	public void disable(int id) {
		userRepository.disable(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public boolean isUniqueUsername(String username){
		boolean unique = true;
		User user = userRepository.findByUsername(username);
		if(user != null) {
			unique = false;
		}
		return unique;
	}
	
	@Transactional(readOnly = true)
	@Override
	public boolean isUniqueEmail(String email){
		boolean unique = true;
		User user = userRepository.findByEmail(email);
		if(user != null) {
			unique = false;
		}
		return unique;
	}
}
