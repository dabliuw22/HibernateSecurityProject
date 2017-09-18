package com.leysoft.hsproject.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "roles")
public class RolUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "tipo", nullable = false, unique = true, length = 15)
	private String tipoRol;

	public RolUser() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipoRol() {
		return tipoRol;
	}

	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}
}
