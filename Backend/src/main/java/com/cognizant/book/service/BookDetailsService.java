package com.cognizant.book.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.book.bean.BookDetails;
import com.cognizant.book.controller.BookDetailsController;
import com.cognizant.book.repository.BookDetailsRepository;

@Service
public class BookDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BookDetailsController.class);

	@Autowired
	public BookDetailsRepository bookDetailsRepository;

	public List<BookDetails> getBookDetailsListCustomer() {
		LOGGER.info("SERVICE WORKS");
		LOGGER.info("data is" + bookDetailsRepository.getBookDetails());
		return bookDetailsRepository.getBookDetails();
	}

	public List<BookDetails> getBookDetailsListAdmin() {

		LOGGER.info("data is" + bookDetailsRepository.findAll());
		return bookDetailsRepository.findAll();
	}

	public BookDetails getBookDetails(long bookDetailsId) {
		
		int bookI = (int) bookDetailsId;

		return bookDetailsRepository.findById(bookI).get();

	}

	public void modifyBookDetails(BookDetails bookDetails) {

		BookDetails b=bookDetailsRepository.findById(bookDetails.getId()).get();
		b.setName(bookDetails.getName());
		b.setPrice(bookDetails.getPrice());
		b.setDateOfPublication(bookDetails.getDateOfPublication());
		b.setCategory(bookDetails.getCategory());
		b.setAvailable(bookDetails.isAvailable());
		b.setFreeDelivery(bookDetails.isFreeDelivery());
	    bookDetailsRepository.save(b);
		
		
	}

}
