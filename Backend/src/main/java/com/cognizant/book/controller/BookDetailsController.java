package com.cognizant.book.controller;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.book.bean.BookDetails;
import com.cognizant.book.security.AppUserDetailsService;
import com.cognizant.book.service.BookDetailsService;

@RestController
@RequestMapping("/menu-items")
public class BookDetailsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookDetailsController.class);

	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
    private BookDetailsService bookDetailsService;
//	@Autowired
//	private InMemoryUserDetailsManager inMemoryUserDetailsManager;

	@GetMapping()
	public ArrayList<BookDetails> getAllBookDetails() {
		LOGGER.info("CONROLLER START");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		System.out.println(user);
		if (user.equals("anonymousUser")) {
			LOGGER.debug("da");
			return (ArrayList<BookDetails>) bookDetailsService.getBookDetailsListCustomer();

		} else {
			UserDetails userDetails = appUserDetailsService.loadUserByUsername(user);
			String role = userDetails.getAuthorities().toArray()[0].toString();
			LOGGER.info(role);
			LOGGER.info("CONTROLLER WORKS");
			if (role.equalsIgnoreCase("role_admin"))
				return (ArrayList<BookDetails>) bookDetailsService.getBookDetailsListAdmin();
			else
				return (ArrayList<BookDetails>) bookDetailsService.getBookDetailsListCustomer();
		}

	}

	@GetMapping("/{id}")
	public BookDetails getBookDetails(@PathVariable long id) {
		return bookDetailsService.getBookDetails(id);
	}

	@PutMapping
	public void modifyBookDetails(@RequestBody BookDetails bookDetails) {
		bookDetailsService.modifyBookDetails(bookDetails);
	}

}
