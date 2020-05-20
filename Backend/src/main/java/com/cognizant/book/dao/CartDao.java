package com.cognizant.book.dao;

import com.cognizant.book.model.Cart;

public interface CartDao {
	public void addCartItem(String userId, long bookDetailsId);

	public Cart getAllCartItems(String userId);

	public void deleteCartItems(String userId, long bookDetailsId);
}
