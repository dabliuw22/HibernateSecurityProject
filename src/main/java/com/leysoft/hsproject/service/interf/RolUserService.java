package com.leysoft.hsproject.service.interf;

import java.util.List;

import com.leysoft.hsproject.entity.RolUser;

public interface RolUserService {
	
public void save(RolUser rol);
	
	public RolUser findById(int id);
	
	public RolUser findByTipo(String tipo);
	
	public List<RolUser> findByAll();
	
	public void update(RolUser rol);
	
	public void delete(int id);
}
