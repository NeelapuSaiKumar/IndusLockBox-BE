package com.orchasp.app.induslockbox.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "company_table")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Long companyid;
	@NotNull
	@Column(name = "company_code")
	private String companyCode;
	@NotNull
	@Column(name = "cin")
	private String cin;
	@NotNull
	@Column(name = "company_name")
	private String companyname;

	@NotNull
	@Column(name = "date_of_incorporation")
	private String dateOfIncorporation;
	@NotNull
	@Column(name = "register_no")
	private String registerNo;
	@NotNull
	@Column(name = "company_land_line")
	private Long telephone;
	@NotNull
	@Column(name = "company_email")
	@Email
	private String email;
	@NotNull
	@Column(name = "address")
	private String address;
	@NotNull
	@Column(name = "company_website")
	private String website;
	@NotNull
	@Column(name = "contact_no")
	private Long contactNo;
	@NotNull
	@Column(name = "fax_no")
	private String faxNo;
	@NotNull
	@Column(name = "city")
	private String city;
	@NotNull
	@Column(name = "state")
	private String state;
	@NotNull
	@Column(name = "pincode")
	private Long pincode;

	private String logoName;

	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	@Column(name = "active/status")
	private boolean active = true;

	public Company() {
		super();
	}

	public Company(Long companyid, @NotNull String companyCode, @NotNull String cin, @NotNull String companyname,
			@NotNull String dateOfIncorporation, @NotNull String registerNo, @NotNull Long telephone,
			@NotNull @Email String email, @NotNull String address, @NotNull String website, @NotNull Long contactNo,
			@NotNull String faxNo, @NotNull String city, @NotNull String state, @NotNull Long pincode, String createdBy,
			String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate, boolean active, String logoName) {
		super();
		this.companyid = companyid;
		this.companyCode = companyCode;
		this.cin = cin;
		this.companyname = companyname;
		this.dateOfIncorporation = dateOfIncorporation;
		this.registerNo = registerNo;
		this.telephone = telephone;
		this.email = email;
		this.address = address;
		this.website = website;
		this.contactNo = contactNo;
		this.faxNo = faxNo;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.active = active;
		this.logoName = logoName;
	}

	public Long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getDateOfIncorporation() {
		return dateOfIncorporation;
	}

	public void setDateOfIncorporation(String dateOfIncorporation) {
		this.dateOfIncorporation = dateOfIncorporation;
	}

	public String getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Long getContactNo() {
		return contactNo;
	}

	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getLogoName() {
		return logoName;
	}

	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}

}
