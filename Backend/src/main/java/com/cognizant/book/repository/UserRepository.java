package com.cognizant.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.book.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String userName);

	@Query(value = "SELECT SUM(b.bo_price) AS cart_total FROM book_details AS b INNER JOIN cart AS c ON b.bo_id = c.ct_bo_id WHERE c.ct_us_id = ?", nativeQuery = true)
	Double getCartTotal(int userId);

}
