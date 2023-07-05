package com.ayaz.android.entities;

import java.util.Date;
import java.util.List;

import org.antlr.v4.runtime.misc.TestRig;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	private String name;
	@Column(length = 1000)
	
	private String imageName;
	
	@Column(length = 1000)	
	private String imageUrl;
	
	@Transient
	private List<MultipartFile> imaages;
	@Column(unique = true)
	
	private String email;
	@Column(unique=true)
	 
	private String mobile;
	
	private String password;
	private String status;
	
	private String otp;
	
	@Column(insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	
	private Date registerTime;

}
