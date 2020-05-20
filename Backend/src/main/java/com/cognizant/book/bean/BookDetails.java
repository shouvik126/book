package com.cognizant.book.bean;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "book_details")
public class BookDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bo_id")
	private Integer id;
	@Column(name = "bo_name")
	private String name;

	@Column(name = "bo_price")
    private Float price;
 

	@Column(name = "bo_available")
	private boolean isAvailable;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Kolkata")
	@Column(name = "bo_date_of_publication")
	private Date dateOfPublication;

	@Column(name = "bo_category")
	private String category;

	@Column(name = "bo_free_delivery")
	private boolean freeDelivery;

	@Column(name = "bo_image")
	private String url;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public Date getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(Date dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "BookDetails [id=" + id + ", name=" + name + ", price=" + price + ", isAvailable=" + isAvailable
				+ ", dateOfPublication=" + dateOfPublication + ", category=" + category + ", freeDelivery="
				+ freeDelivery + ", url=" + url + "]";
	}

	public BookDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDetails(Integer id, String name, Float price, boolean isAvailable, Date dateOfPublication,
			String category, boolean freeDelivery, String url) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.isAvailable = isAvailable;
		this.dateOfPublication = dateOfPublication;
		this.category = category;
		this.freeDelivery = freeDelivery;
		this.url = url;
	}


}
