package com.orchasp.app.induslockbox.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "director_table")
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "director_id")
	private Long id;
	@NotNull
	@Column(name = "director_name")
	private String name;
	@NotNull
	@Email
	@Column(name = "director_email")
	private String email;
	@NotNull
	@Column(name = "din_no")
	private Long dinNo;
	@NotNull
	@Column(name = "aadhar_no")
	private Long aadharNo;
	@Column(name = "pan_no")
	private String panNo;
	@Column(name = "passport_no")
	private String passportNo;
	@Column(name = "designation")
	private String designation;
	@Column(name = "date_of_appointment")
	private String dateOfAppointment;
	@Column(name = "date_of_exit")
	private String dateOfExit;
	@NotNull
	@Column(name = "mobile_no")
	private Long mobileNo;
	@Column(name = "address")
	private String address;
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
	@Lob
	@Column(name="photo")
	private String imageName;


		
	

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public Director() {
		super();
	}

	public Director(Long id, @NotNull String name, @NotNull @Email String email, @NotNull Long dinNo,
			@NotNull Long aadharNo, String panNo, String passportNo, String designation, String dateOfAppointment,
			String dateOfExit, @NotNull Long mobileNo, String address, String createdBy, String updatedBy,
			LocalDateTime createdDate, LocalDateTime updatedDate, boolean active, String imageName,
			Company company) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dinNo = dinNo;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
		this.passportNo = passportNo;
		this.designation = designation;
		this.dateOfAppointment = dateOfAppointment;
		this.dateOfExit = dateOfExit;
		this.mobileNo = mobileNo;
		this.address = address;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.active = active;
		this.imageName = imageName;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getDinNo() {
		return dinNo;
	}

	public void setDinNo(Long dinNo) {
		this.dinNo = dinNo;
	}

	public Long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDateOfAppointment() {
		return dateOfAppointment;
	}

	public void setDateOfAppointment(String dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	public String getDateOfExit() {
		return dateOfExit;
	}

	public void setDateOfExit(String dateOfExit) {
		this.dateOfExit = dateOfExit;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}
