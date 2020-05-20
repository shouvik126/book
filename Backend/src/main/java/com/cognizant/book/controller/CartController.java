package com.cognizant.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.book.model.Cart;
import com.cognizant.book.service.CartService;

@RestController
@RequestMapping("/cart-items")
public class CartController {

	@Autowired
	public CartService cartService;

	@PostMapping("/{userId}/{bookDetailsId}")
	public void addCartItem(@PathVariable String userId, @PathVariable long bookDetailsId) {
		cartService.addCartItem(userId, bookDetailsId);
	}

	@GetMapping("/{userId}")
	public Cart getAllCartItems(@PathVariable String userId) {
		return cartService.getAllCartItems(userId);
	}

	@DeleteMapping("/{userId}/{bookDetailsId}")
	public void deleteCartItems(@PathVariable String userId, @PathVariable long bookDetailsId) {
		cartService.deleteCartItems(userId, bookDetailsId);
	}

}
