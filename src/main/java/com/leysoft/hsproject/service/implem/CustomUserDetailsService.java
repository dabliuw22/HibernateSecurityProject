package com.leysoft.hsproject.service.implem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.leysoft.hsproject.entity.RolUser;
import com.leysoft.hsproject.entity.User;
import com.leysoft.hsproject.service.interf.UserService;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired @Qualifier("userService")
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		 return new org.springframework.security.core.userdetails
					.User(user.getUsername(), user.getPassword(), user.isEnable(), 
							true, true, true, (Collection<GrantedAuthority>) getAuthorities(user));
	}
	
	private List<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		user.getRoles()
			.forEach((RolUser rol) 
					-> authorities.add(new SimpleGrantedAuthority("ROLE_"+rol.getTipoRol())));
		return authorities;
	}
}
