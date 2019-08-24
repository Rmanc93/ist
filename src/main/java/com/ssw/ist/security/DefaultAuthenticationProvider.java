package com.ssw.ist.security;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssw.ist.model.Employee;
import com.ssw.ist.model.Role;
import com.ssw.ist.service.RoleService;
import com.ssw.ist.service.UserService;

@Service
@EntityScan("com.ssw.ist.model")
public class DefaultAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;
	
	private RoleService roleService;
	


	@Override
	@Transactional
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (authentication.getName() == null || authentication.getCredentials() == null) {
			return null;
		}

		final String userName = authentication.getName();
		final String userPassword = authentication.getCredentials().toString();

		if (userName == null || userPassword == null) {
			return null;
		}

		if (userName.isEmpty() || userPassword.toString().isEmpty()) {
			return null;
		}
		Employee user =userService.findByUsername(userName);


		if (passwordEncoder.matches(userPassword, user.getPassword())) {
		
			return new UsernamePasswordAuthenticationToken(userName, userPassword, getAuthority(user.getRole()));
		}

		throw new UsernameNotFoundException("Invalid username or password.");
	}

	private List<SimpleGrantedAuthority> getAuthority(Role role) {
		List<SimpleGrantedAuthority> grantedAuths= new ArrayList();
		
		
			grantedAuths.add(new SimpleGrantedAuthority(role.getName()));
		
		
		return grantedAuths;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}


}
