package com.cognizant.book.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.book.bean.BookDetails;


public interface BookDetailsDao {
	public List<BookDetails> getBookDetailsListAdmin();

	public ArrayList<BookDetails> getBookDetailsListCustomer();

	public void modifyBookDetails(BookDetails bookDetails);

	public BookDetails getBookDetails(long bookDetailsId);

}
