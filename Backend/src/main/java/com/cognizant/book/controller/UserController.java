package com.cognizant.book.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.book.bean.User;
import com.cognizant.book.exception.UserAlreadyExistsException;
import com.cognizant.book.security.AppUserDetailsService;

@RestController
@RequestMapping("/users")
public class UserController {
//    
	@Autowired
	AppUserDetailsService appUserDetailsService;

//    @Autowired
//    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
//    
//    public static List<UserDetails> userDetailsList = new ArrayList<>();
//    
//    
//    public UserController() {
//        super();
//        userDetailsList.add(
//                org.springframework.security.core.userdetails.User.withUsername("user")
//                    .password(passwordEncoder()
//                    .encode("pwd"))
//                    .roles("USER").build());
//            
//            userDetailsList.add(
//                    org.springframework.security.core.userdetails.User.withUsername("admin")
//                    .password(passwordEncoder()
//                    .encode("pwd"))
//                    .roles("ADMIN").build()); 
//            
//            userDetailsList.add(
//                    org.springframework.security.core.userdetails.User.withUsername("anonymousUser")
//                        .password(passwordEncoder()
//                        .encode("pwd"))
//                        .roles("ANONYMOUS").build());
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

	@PostMapping
	public void signup(@RequestBody @Valid User user) {
//        boolean userDetails = inMemoryUserDetailsManager.userExists(user.getUserName());
//        if(!userDetails) {
//           inMemoryUserDetailsManager.createUser(org.springframework.security.core.userdetails.User
//                    .withUsername(user.getUserName()).password(passwordEncoder().encode(user.getPassword()))
//                            .roles("USER").build());
//            userDetailsList.add(org.springframework.security.core.userdetails.User
//                    .withUsername(user.getUserName()).password(passwordEncoder().encode(user.getPassword()))
//                    .roles("USER").build());
//
		try {
			appUserDetailsService.signUp(user);
		} catch (UserAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//        }
	}

}
