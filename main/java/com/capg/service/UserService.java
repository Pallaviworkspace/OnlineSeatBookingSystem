package com.capg.service;
import org.springframework.http.ResponseEntity;

import com.capg.entity.User;
import com.capg.exception.BookingNotFoundException;
import com.capg.exception.UserNotFoundException;

public interface UserService {

	public User addUser(User user);
	public User loginUser(String emailId,String password)throws UserNotFoundException;
	public User findByUserEmailId(String emailId)throws UserNotFoundException;
	public boolean isAdmin(String emailId);
	public boolean validateSecurityAnswer(String emailId,String securityAnswer);
	public void resetPassword(String emailId,String password);
	public User deleteUserByEmailId(String emailId,String password);
	public void updateUserByEmailId(String emailId,String password) throws UserNotFoundException;
	public User findByEmailId(String emailId);
	public void save(User users);
	public boolean swapBookings(int bookingId1, int bookingId2) throws BookingNotFoundException;
}
