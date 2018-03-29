package com.teste.ampulheta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.teste.ampulheta.domain.User;
import com.teste.ampulheta.repositories.UserRepository;
import com.teste.ampulheta.security.UserSS;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = repo.findByEmail(email);
		if(user == null) {
			throw new  UsernameNotFoundException(email);
		}
		
		return new UserSS(user.getUser_id(),user.getEmail(),user.getLogin(),user.getPassword(),user.getPerfis());
	}

}
