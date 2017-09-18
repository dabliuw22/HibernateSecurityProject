package com.leysoft.hsproject.repository.interf;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.leysoft.hsproject.entity.RolUser;

public interface RolUserRepository {
	
	@Secured({"ADMIN"})
	public void save(RolUser rol);
	
	public RolUser findById(int id);
	
	public RolUser findByTipo(String tipo);
	
	public List<RolUser> findByAll();
	
	@Secured({"ADMIN"})
	public void update(RolUser rol);
	
	@Secured({"ADMIN"})
	public void delete(int id);
}
