package com.bt.demo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bt.demo.app.model.User;
import com.bt.demo.app.repository.UserRepository;

public class GuestBookUserDetailsImpl implements UserDetailsService {


	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username); 
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		} 
		return new GuestBookUserDetails(user);
	}
}
