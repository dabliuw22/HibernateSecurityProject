package com.leysoft.hsproject.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity @Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	@Column(nullable = false, unique = true, length = 50)
	private String username;
	
	@Column(nullable = false, length = 20)
	private String nombre;
	
	@Column(nullable = false, length = 30)
	private String apellidos;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@Column(nullable = false)
	private boolean enable;
	
	@Column(nullable = false)
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name = "user_id", nullable = false)}
			, inverseJoinColumns = {@JoinColumn(name = "rol_id", nullable = false)})
	private List<RolUser> roles = new ArrayList<RolUser>();

	public User() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RolUser> getRoles() {
		return roles;
	}

	public void setRoles(List<RolUser> roles) {
		this.roles = roles;
	}
}
