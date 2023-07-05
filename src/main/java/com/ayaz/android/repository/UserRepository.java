package com.ayaz.android.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ayaz.android.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	
	//  User findByEmials(@Param("email") String email);
//	  
//	  @Query("SELECT u FROM User WHERE u.email  = :e AND u.password = :p") //User
//	   User findByPassword(@Param("password") String password);
//	 
	  
	

}
