package com.leysoft.hsproject.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.leysoft.hsproject.service.implem.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired @Qualifier("userDetailsService")
	private CustomUserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/form-user", "/registro", "/login").anonymous()
			.antMatchers("/admin/**").access("hasRole('ADMIN')")
			.antMatchers("/user/**").access("hasRole('USER') or hasRole('ADMIN')")
			.and().formLogin().loginPage("/login").defaultSuccessUrl("/", true)
				.usernameParameter("username").passwordParameter("password")
			.and().rememberMe().rememberMeParameter("remember").tokenValiditySeconds(86400).key("remember_key")
			.and().csrf()
			.and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
			.and().exceptionHandling().accessDeniedPage("/access_denied");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
}
