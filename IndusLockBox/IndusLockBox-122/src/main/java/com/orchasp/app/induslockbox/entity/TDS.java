package com.orchasp.app.induslockbox.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class TDS {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tan_id")
    private Long id;
	@NotNull
	@Column(name="tan_No")
	private String tanNo;
	@NotNull
	@Column(name="email")
	private String email;
	@NotNull
	@Column(name="phone_number")
	private String phoneNumber;
	@NotNull
	@Column(name="user_id")
	private String userid;
	@NotNull
	@Column(name="password")
	private String password;
	@NotNull
	@Column(name="surrendered")
	private String surrendered;
	@NotNull
	@Column(name="signatory")
	private String signatory;
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
	public TDS() {
		
	}
	public TDS(Long id,String tanNo,  String email,  String phoneNumber,
			 String userid,  String password,  String surrendered,  String signatory,
			String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate, boolean active,Company company) {
		super();
		this.id = id;
		this.tanNo = tanNo;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userid = userid;
		this.password = password;
		this.surrendered = surrendered;
		this.signatory = signatory;
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
	public String getTanNo() {
		return tanNo;
	}
	public void setTanNo(String tanNo) {
		this.tanNo = tanNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSurrendered() {
		return surrendered;
	}
	public void setSurrendered(String surrendered) {
		this.surrendered = surrendered;
	}
	public String getSignatory() {
		return signatory;
	}
	public void setSignatory(String signatary) {
		this.signatory = signatary;
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
