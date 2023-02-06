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


@Entity 
public class Admin {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aId;

	private String adminName;
	
	private String emailId;
	
	private String username;
	
	private String password;
	
	private String role;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "u_id", referencedColumnName = "uId")
	private User user;
	
	@OneToMany(mappedBy = "admin" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Seat> seats;
	
	@OneToMany(mappedBy = "admin" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Bookingdetails> bookingdetails;
	
	public Admin() {
		super();
	}

	public Admin(int aId, String adminName, String emailId, String username, String password, String role, User user,
			List<Seat> seats, List<Bookingdetails> bookingdetails) {
		super();
		this.aId = aId;
		this.adminName = adminName;
		this.emailId = emailId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.user = user;
		this.seats = seats;
		this.bookingdetails = bookingdetails;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public List<Bookingdetails> getBookingdetails() {
		return bookingdetails;
	}

	public void setBookingdetails(List<Bookingdetails> bookingdetails) {
		this.bookingdetails = bookingdetails;
	}

	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", adminName=" + adminName + ", aemailId=" + emailId + ", password=" + password
				+ "]";
	}

	
}
