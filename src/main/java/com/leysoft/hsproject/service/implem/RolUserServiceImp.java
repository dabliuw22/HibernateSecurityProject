package com.leysoft.hsproject.service.implem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leysoft.hsproject.entity.RolUser;
import com.leysoft.hsproject.repository.interf.RolUserRepository;
import com.leysoft.hsproject.service.interf.RolUserService;

@Service("rolUserService") @Transactional
public class RolUserServiceImp implements RolUserService {
	
	@Autowired @Qualifier("rolUserRepository")
	private RolUserRepository rolUserRepository;

	@Override @Transactional
	public void save(RolUser rol) {
		rolUserRepository.save(rol);
	}

	@Override @Transactional(readOnly = true)
	public RolUser findById(int id) {
		return rolUserRepository.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public RolUser findByTipo(String tipo) {
		return rolUserRepository.findByTipo(tipo);
	}

	@Override @Transactional(readOnly = true)
	public List<RolUser> findByAll() {
		return rolUserRepository.findByAll();
	}

	@Override @Transactional
	public void update(RolUser rol) {
		rolUserRepository.update(rol);
	}

	@Override @Transactional
	public void delete(int id) {
		rolUserRepository.delete(id);
	}

	
}
