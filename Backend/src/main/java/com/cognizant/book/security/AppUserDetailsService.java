package com.cognizant.book.security;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.book.bean.Role;
import com.cognizant.book.bean.User;
import com.cognizant.book.exception.UserAlreadyExistsException;
import com.cognizant.book.repository.RoleRepository;
import com.cognizant.book.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	AppUser appUser;
	User user;

	public AppUserDetailsService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public AppUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		user = userRepository.findByUserName(username);
		if (user == null)
			throw new UsernameNotFoundException("username not found");
		else
			appUser = new AppUser(user);
		return appUser;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public void signUp(@Valid User user2) throws UserAlreadyExistsException {

		User check = userRepository.findByUserName(user2.getUserName());

		if (check != null) {
			throw new UserAlreadyExistsException();
		}

		else {

			user2.setPassword(SecurityConfig.passwordEncoder().encode(user2.getPassword()));
			// TODO Auto-generated method stub
			LOGGER.info("pass is " + user2.getPassword());
			LOGGER.info("name is  is " + user2.getUserName());
			// user2.setPassword(passwordEncoder().encode(user2.getPassword()));

			Role role = roleRepository.findByRoleId(2);

			Set<Role> role1 = new HashSet<Role>();
			role1.add(role);

			user2.setRoleList(role1);

			LOGGER.info("role  is " + user2.getRoleList());

			userRepository.save(user2);

		}

	}

}
