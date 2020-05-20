package com.cognizant.book.model;

import java.util.List;

import com.cognizant.book.bean.BookDetails;


public class Cart {
	private List<BookDetails> bookDetailsList;
	private double total;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<BookDetails> getBookDetailsList() {
		return bookDetailsList;
	}

	public void setBookDetailsList(List<BookDetails> bookDetailsList) {
		this.bookDetailsList = bookDetailsList;
	}

	public Cart(List<BookDetails> bookDetailsList, double total) {
		super();
		this.bookDetailsList = bookDetailsList;
		this.total = total;
	}

	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookDetailsList == null) ? 0 : bookDetailsList.hashCode());
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (bookDetailsList == null) {
			if (other.bookDetailsList != null)
				return false;
		} else if (!bookDetailsList.equals(other.bookDetailsList))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart [bookDetailsList=" + bookDetailsList + ", total=" + total + "]";
	}

}
