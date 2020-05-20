package com.cognizant.book.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.book.bean.BookDetails;


public interface BookDetailsRepository extends JpaRepository<BookDetails, Integer> {
	@Query(value = "select * from book.book_details where bo_available = '1' && bo_date_of_publication < \"2019-01-01\" || bo_free_delivery='1'", nativeQuery = true)
	List<BookDetails> getBookDetails();

	public Optional<BookDetails> findById(int bookDetailsId);

}
