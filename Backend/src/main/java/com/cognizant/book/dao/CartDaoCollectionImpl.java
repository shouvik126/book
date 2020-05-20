package com.cognizant.book.dao;
//package com.cognizant.book.dao;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import org.springframework.stereotype.Component;
//
//import com.cognizant.book.model.Cart;
//import com.cognizant.book.bean.MenuItem;
//
//@Component
//public class CartDaoCollectionImpl implements CartDao {
//	private static HashMap<String, Cart> userCarts;
//	private List<MenuItem> menuItemList = null;
//	private Cart cart = null;
//
//	public CartDaoCollectionImpl() {
//		super();
//		if (userCarts == null)
//			userCarts = new HashMap<String, Cart>();
//	}
//
//	@Override
//	public void addCartItem(String userId, long menuItemId) {
//		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
//		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
//
//		cart = userCarts.get(userId);
//		if (cart != null) {
//			menuItemList = cart.getMenuItemList();
//			menuItemList.add(menuItem);
//		} else {
//			menuItemList = new ArrayList<MenuItem>();
//			cart = new Cart(menuItemList, 0.0);
//			cart.getMenuItemList().add(menuItem);
//			userCarts.put(userId, cart);
//		}
//	}
//
//	@Override
//	public Cart getAllCartItems(String userId) {
//		double total = 0.0;
//
//		cart = userCarts.get(userId);
//		if (cart != null) {
//			menuItemList = cart.getMenuItemList();
//			if (menuItemList == null || menuItemList.isEmpty()) {
//				/* Exception has been removed */
//				// System.out.println("null");
//				cart.setTotal(0.0);
//				// System.out.println(total);
//			} else {
//				for (MenuItem menuItem : menuItemList) {
//					total += menuItem.getPrice();
//				}
//				cart.setTotal(total);
//				// System.out.println(total);
//			}
//		}
//		return cart;
//	}
//
//	@Override
//	public void deleteCartItems(String userId, long menuItemId) {
//		cart = userCarts.get(userId);
//		menuItemList = cart.getMenuItemList();
//		int indexOfMatchingItem = 0;
//		for (MenuItem menuItem : menuItemList) {
//			if (menuItem.getId() == menuItemId) {
//				indexOfMatchingItem = menuItemList.indexOf(menuItem);
//				break;
//			}
//		}
//		menuItemList.remove(indexOfMatchingItem);
//	}
//}
