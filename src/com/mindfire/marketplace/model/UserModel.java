package com.mindfire.marketplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {
	
	@Id
	@Column(name = "p_userid")
	private String UserID;

	@Column(name = "p_emailid")
	private String emailID;
	
	@Column(name = "p_passwordencoded")
	private String passwordEncoded;
	
	@Column(name = "p_role")
	private String role;
	
	@Column(name = "p_imageurl")
	private String imageURL;
	
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPasswordEncoded() {
		return passwordEncoded;
	}
	public void setPasswordEncoded(String passwordEncoded) {
		this.passwordEncoded = passwordEncoded;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	

}
