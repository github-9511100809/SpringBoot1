package com.ayaz.android.services;

import com.ayaz.android.entities.User;

public interface UserService {
	
	public String userRegister(User user);
	public User findByEmails(String email);
	public String loginUser(User UserEntity);
	public String updateUser(String oldPass,String newPass,String email);
	
	   public String otpVerfy(User user);
	   
	     

}
