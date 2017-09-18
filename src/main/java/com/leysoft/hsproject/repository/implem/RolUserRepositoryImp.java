package com.leysoft.hsproject.repository.implem;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leysoft.hsproject.entity.RolUser;
import com.leysoft.hsproject.repository.interf.RolUserRepository;

@Repository("rolUserRepository")
public class RolUserRepositoryImp implements RolUserRepository {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(RolUser rol) {
		sessionFactory.getCurrentSession().saveOrUpdate(rol);
	}

	@Override
	public RolUser findById(int id) {
		return (RolUser) sessionFactory.getCurrentSession().get(RolUser.class, id);
	}

	@Override
	public RolUser findByTipo(String tipo) {
		return (RolUser) sessionFactory.getCurrentSession()
				.createQuery("from RolUser as r where r.tipoRol = :tipo")
				.setParameter("tipo", tipo).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RolUser> findByAll() {
		return sessionFactory.getCurrentSession().createQuery("from RolUser").list();
	}

	@Override
	public void update(RolUser rol) {
		sessionFactory.getCurrentSession().update(rol);
	}

	@Override
	public void delete(int id) {
		sessionFactory.getCurrentSession().delete(id);
	}

}
