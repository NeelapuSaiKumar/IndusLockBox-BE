package com.orchasp.app.induslockbox.dto;

import lombok.Data;

@Data
public class DirectorForm {

	private String name;
	private String email;
	private Long dinNo;
	private Long aadharNo;
	private String panNo;
	private String passportNo;
	private String designation;
	private String dateOfAppointment;
	private String dateOfExit;
	private Long mobileNo;
	private String address;
	private String createdBy;
	private String updatedBy;
	private boolean active = true;

	private long companyid;

}
