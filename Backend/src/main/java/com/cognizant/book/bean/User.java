package com.cognizant.book.bean;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private Integer id;

	@Column(name = "us_name")
	private String userName;

	@Column(name = "us_password")
	private String password;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "us_ro_id") private Role role;
	 */
	/*
	 * @OneToMany(cascade=CascadeType.ALL) private Set<Role> roles = new
	 * HashSet<>();
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "ur_us_id"), inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
	private Set<Role> roleList;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "cart", joinColumns = @JoinColumn(name = "ct_us_id"), inverseJoinColumns = @JoinColumn(name = "ct_bo_id"))
	private List<BookDetails> bookDetailsList;

	public Set<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}

	
	public List<BookDetails> getBookDetailsList() {
		return bookDetailsList;
	}

	public void setBookDetailsList(List<BookDetails> bookDetailsList) {
		this.bookDetailsList = bookDetailsList;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Integer id, String userName, String password, Set<Role> roleList, List<BookDetails> bookDetailsList) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.roleList = roleList;
		this.bookDetailsList = bookDetailsList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", roleList=" + roleList
				+ ", bookDetailsList=" + bookDetailsList + "]";
	}

	

}
