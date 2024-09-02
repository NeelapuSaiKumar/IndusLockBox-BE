package com.orchasp.app.induslockbox.dto;

import java.time.LocalDateTime;


import lombok.Data;

@Data
public class CompanyDTO {

	private String companyCode;

	private String cin;

	private String companyname;

	
	private String dateOfIncorporation;

	private String registerNo;

	private Long telephone;
	
	private String email;

	private String address;

	private String website;

	private Long contactNo;

	private String faxNo;

	private String city;

	private String state;

	private Long pincode;
	
	private String logoName;


	private String createdBy;
	
	private String updatedBy;

	private LocalDateTime createdDate;

	private LocalDateTime updatedDate;
	
	private boolean active = true;
}
