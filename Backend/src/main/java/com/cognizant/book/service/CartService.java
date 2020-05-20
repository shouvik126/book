package com.cognizant.book.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.book.bean.BookDetails;

import com.cognizant.book.bean.User;
import com.cognizant.book.model.Cart;
import com.cognizant.book.repository.BookDetailsRepository;

import com.cognizant.book.repository.UserRepository;

import org.slf4j.Logger;

@Service
public class CartService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);


	@Autowired
	BookDetailsRepository bookDetailsRepository;

	@Autowired
	UserRepository userRepository;

	public void addCartItem(String userId, long bookDetailsId) {
		// cartDao.addCartItem(userId, bookDetailsId);

		User user = userRepository.findByUserName(userId);

		BookDetails bookDetails = bookDetailsRepository.findById((int) bookDetailsId).get();
		if (bookDetails != null) {
			List<BookDetails> a = new ArrayList<BookDetails>();
			a = user.getBookDetailsList();
			a.add(bookDetails);
			user.setBookDetailsList(a);
			userRepository.save(user);

		}

	}

	public Cart getAllCartItems(String userId) {



		Cart cart = new Cart();

		User user = userRepository.findByUserName(userId);
		

		LOGGER.info("cart is " + user.getBookDetailsList());

		cart.setBookDetailsList(user.getBookDetailsList());

		LOGGER.info("cart1 is " + cart.getBookDetailsList());

		try {
			cart.setTotal(userRepository.getCartTotal(user.getId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cart;

	}

	public void deleteCartItems(String userId, long bookDetailsId) {

		User user = userRepository.findByUserName(userId);

		LOGGER.info("delete cart is " + user);

		BookDetails bookDetails = bookDetailsRepository.findById((int) bookDetailsId).get();

		LOGGER.info("delete cart1 is " + bookDetails);

		List<BookDetails> a = user.getBookDetailsList();
		a.remove(bookDetails);
		user.setBookDetailsList(a);
		userRepository.save(user);

	}

}
