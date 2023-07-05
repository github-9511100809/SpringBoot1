package com.ayaz.android.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResponseErrorHandler;

import com.ayaz.android.entities.User;
import com.ayaz.android.helpers.ResponseHandler;
import com.ayaz.android.services.UserService;

@RestController
@RequestMapping (path ="/restapi")
public class UserController {
	@Autowired
	 UserService service;
	   
	
	@PostMapping(path ="/register")
	
	public ResponseEntity<Object>  registerUser(@RequestBody User user) {
		
		   
		try {
			String msg=service.userRegister(user);
			 if(msg.equals("succsess")) {
				 return ResponseHandler.genrateResponse(HttpStatus.OK, true, msg,user);
			 }
			 else if (msg.contentEquals("fail")){
				 return ResponseHandler.genrateResponse(HttpStatus.METHOD_FAILURE, false, msg,user);
			}
			
			 else {
				 return ResponseHandler.genrateResponse(HttpStatus.OK, true, msg,user);
			}
		} catch (Exception e) {
			 return ResponseHandler.genrateResponse(HttpStatus.METHOD_FAILURE, false, "error_505",user);
		}
		
		
		
	
	

}
}