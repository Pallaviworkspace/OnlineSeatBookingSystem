package com.capg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/*
 {
	"emailId" : "zames@gmail.com",
	"password" : "Kiran@123",
	"securityAnswer" : "Whats your pet name?",
	"role" : "SDE"
}

 {
	"emailId" : "RayJones@gmail.com",
	"password" : "Ray@123",
	"securityAnswer" : "Whats your pet name?",
	"role" : "SDE"
}
 */

@Entity
@Table(name="Users_detail")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uId;
	
	private String emailId;
	
	private String password;

	private String securityAnswer;
	
	private String role;
	
	@OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Booking> bookings;

	public User() {
		super();
	}

	public User(int uId, String emailId, String password, String securityAnswer, String role, List<Booking> bookings) {
		super();
		this.uId = uId;
		this.emailId = emailId;
		this.password = password;
		this.securityAnswer = securityAnswer;
		this.role = role;
		this.bookings = bookings;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	
	@Override
	public String toString() {
		return "User [uId=" + uId + ", emailId=" + emailId + ", password=" + password + ", securityAnswer="
				+ securityAnswer + "]";
	}
	
}

