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
//	@Entity
//	@Table(name = "user_role")
//	public class UserRole {
//		
//		@Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//		@Column(name="ur_id")
//		private Integer userRoleId;
//		
//		@Column(name="ur_us_id")	
//		private Integer userRoleUserId;
//		
//		@Column(name="ur_ro_id")
//		private Integer userRoleRoleId;
//
//		public UserRole() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//
//		public UserRole(Integer userRoleId, Integer userRoleUserId, Integer userRoleRoleId) {
//			super();
//			this.userRoleId = userRoleId;
//			this.userRoleUserId = userRoleUserId;
//			this.userRoleRoleId = userRoleRoleId;
//		}
//
//		public Integer getUserRoleId() {
//			return userRoleId;
//		}
//
//		public void setUserRoleId(Integer userRoleId) {
//			this.userRoleId = userRoleId;
//		}
//
//		public Integer getUserRoleUserId() {
//			return userRoleUserId;
//		}
//
//		public void setUserRoleUserId(Integer userRoleUserId) {
//			this.userRoleUserId = userRoleUserId;
//		}
//
//		public Integer getUserRoleRoleId() {
//			return userRoleRoleId;
//		}
//
//		public void setUserRoleRoleId(Integer userRoleRoleId) {
//			this.userRoleRoleId = userRoleRoleId;
//		}
//
//		@Override
//		public String toString() {
//			return "UserRole [userRoleId=" + userRoleId + ", userRoleUserId=" + userRoleUserId + ", userRoleRoleId="
//					+ userRoleRoleId + "]";
//		}
//		
//		
//
//}
