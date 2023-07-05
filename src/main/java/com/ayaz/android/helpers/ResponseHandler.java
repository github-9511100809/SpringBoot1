package com.ayaz.android.helpers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
	
	 public static ResponseEntity<Object> genrateResponse(HttpStatus status ,boolean error,String messsage,Object responseObject) {
		   
		 
		 Map<String , Object> map=new HashMap<>();
		 try {
			 map.put("status", status.value());
			 map.put("timestamp", new Date());
			 map.put("isSuccsess", error);
			 map.put("message", messsage);
			 map.put("data", responseObject);
			return  new ResponseEntity<Object>(map,status);
			
		} catch (Exception e) {
			
			 map.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
			 map.put("timestamp", new Date());
			 map.put("isSuccsess", false);
			 map.put("message", e.getMessage());
			 map.put("data", null);
			return  new ResponseEntity<Object>(map,status);
			
			
		}
		 
		 
		 
		 
		 
		 
		 
		 
	}

}
