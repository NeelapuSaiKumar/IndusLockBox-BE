package com.orchasp.app.induslockbox.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="kmp_table")
public class KMP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="kmp_id")
	private Long id;
	@NotNull
	@Column(name="name")
	private String name;
	@NotNull
	@Email
	@Column(name="email")
	private String email;
    @NotNull
	@Column(name="aadhar_no")
	private Long aadharNo;
	@NotNull
	@Column(name="passport_no")
	private String passportNo;
	@NotNull
	@Column(name="pan_no")
	private String panNo;
	@NotNull
	@Column(name="designation")
	private String designation;
	@NotNull
	@Column(name="address")
	private String address;
	@NotNull
	@Column(name="state")
	private String state;
	
	@Column(name="photo")
	private String photoName;
	
	@NotNull
	@Column(name="mobile_no")
	private String mobileNo;
	
	
	@Column(name="resume")
    private String resumeName;
	@Column(name="created_by")
	private String createdBy;
	@Column(name="updated_by")
	private String updatedBy;
	@Column(name="created_date")
	private LocalDateTime createdDate;
	@Column(name="updated_date")
	private LocalDateTime updatedDate;
	@Column(name="active/status")
	 private boolean active = true;
	
	
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public KMP() {
		super();
	}

	public KMP(Long id, @NotNull String name, @NotNull @Email String email, @NotNull Long aadharNo,
			@NotNull String passportNo, @NotNull String panNo, @NotNull String designation, @NotNull String address,
			@NotNull String state, @NotNull String photoName, @NotNull String mobileNo, @NotNull String resumeName,
			String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate, boolean active,
			Company company) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.aadharNo = aadharNo;
		this.passportNo = passportNo;
		this.panNo = panNo;
		this.designation = designation;
		this.address = address;
		this.state = state;
		this.photoName = photoName;
		this.mobileNo = mobileNo;
		this.resumeName = resumeName;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.active = active;
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

	public Long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getResumeName() {
		return resumeName;
	}

	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
}
