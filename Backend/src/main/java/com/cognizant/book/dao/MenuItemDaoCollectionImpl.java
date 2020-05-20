package com.cognizant.book.dao;
//package com.cognizant.book.dao;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//import com.cognizant.book.controller.MenuItemController;
//import com.cognizant.book.bean.MenuItem;
//
//@Component
//public class MenuItemDaoCollectionImpl implements MenuItemDao {
//	private static List<MenuItem> menuItemList;
//	private MenuItem searchItem = null;
//	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
//
//	public MenuItemDaoCollectionImpl() {
//		super();
//		LOGGER.info("COLLECTIONIMPL WORKS");
//		if (menuItemList == null) {
//			ApplicationContext context = new ClassPathXmlApplicationContext("book.xml");
//			menuItemList = (ArrayList<MenuItem>) context.getBean("MenuItemList");
//		}
//	}
//
//	@Override
//	public List<MenuItem> getMenuItemListAdmin() {
//		return menuItemList;
//	}
//
//	@Override
//	public ArrayList<MenuItem> getMenuItemListCustomer() {
//		List<MenuItem> menuItemListCustomer = new ArrayList<MenuItem>();
//		for (MenuItem menuItem : menuItemList) {
//			if (!menuItem.getDateOfPublication().after(new Date()) && menuItem.isisAvailable()) {
//				menuItemListCustomer.add(menuItem);
//			}
//		}
//		return (ArrayList<MenuItem>) menuItemListCustomer;
//	}
//
//	@Override
//	public void modifyMenuItem(MenuItem menuItem) {
//		searchItem = getMenuItem(menuItem.getId());
//		int indexOfSearchItem = menuItemList.indexOf(searchItem);
//		menuItemList.set(indexOfSearchItem, menuItem);
//	}
//
//	@Override
//	public MenuItem getMenuItem(long menuItemId) {
//		for (MenuItem menuItem : menuItemList) {
//			if (menuItem.getId() == menuItemId) {
//				searchItem = menuItem;
//				return searchItem;
//			}
//		}
//		return null;
//	}
//
//}
