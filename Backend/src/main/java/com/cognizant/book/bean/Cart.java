package com.cognizant.book.bean;
//package com.cognizant.book.bean;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//
//	@Entity
//	@Table(name = "cart")
//	public class Cart {
//		
//		@Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//		@Column(name="ct_id")
//		private Integer cartId;
//		
//		@Column(name="ct_us_id")	
//		private Integer cartUserId;
//
//		
//		@Column(name="ct_pr_id")
//		private Integer cartProductId;
//
//
//		public Cart() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//
//
//		public Cart(Integer cartId, Integer cartUserId, Integer cartProductId) {
//			super();
//			this.cartId = cartId;
//			this.cartUserId = cartUserId;
//			this.cartProductId = cartProductId;
//		}
//
//
//		public Integer getCartId() {
//			return cartId;
//		}
//
//
//		public void setCartId(Integer cartId) {
//			this.cartId = cartId;
//		}
//
//
//		public Integer getCartUserId() {
//			return cartUserId;
//		}
//
//
//		public void setCartUserId(Integer cartUserId) {
//			this.cartUserId = cartUserId;
//		}
//
//
//		public Integer getCartProductId() {
//			return cartProductId;
//		}
//
//
//		public void setCartProductId(Integer cartProductId) {
//			this.cartProductId = cartProductId;
//		}
//
//
//		@Override
//		public String toString() {
//			return "Cart [cartId=" + cartId + ", cartUserId=" + cartUserId + ", cartProductId=" + cartProductId + "]";
//		}
//		
//		
//		
//}
