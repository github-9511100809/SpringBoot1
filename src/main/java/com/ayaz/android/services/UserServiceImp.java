package com.ayaz.android.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayaz.android.entities.User;
import com.ayaz.android.helpers.SendEmail;
import com.ayaz.android.repository.UserRepository;
@Service
public class UserServiceImp implements UserService{
	  @Autowired
     UserRepository userRepo;
	@Override
	public String userRegister(User user) {
		   if(findByEmails(user.getEmail())!=null){
			   return "exist";
			   
		   }
		   else {
			   Random random=new Random(); 
			 int randomNum=random.nextInt(871871);
			 user.setOtp(String.valueOf(randomNum));
			 user.setStatus("inactive");
			 User UserEntity2=userRepo.save(user);
			 if(UserEntity2 !=null) {
				 SendEmail.sendmail(UserEntity2.getEmail(),String.valueOf(randomNum));
				 return "succsess";
			 }
			 
			 else {
				return "fail";
			}
			 
		}
		   
		
	}

	@Override
	public User findByEmails(String email) {
				return null;
	}

	@Override
	public String loginUser(User UserEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateUser(String oldPass, String newPass, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String otpVerfy(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
