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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="esi_table")
public class ESI {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="esi_id")
	private Long id;
	@NotNull
	@Column(name="employer_codeNo")
	private Long employerCodeNo;
	@NotNull
	@Column(name="employer_name")
	private String employerName;
	@NotNull
	@Column(name="regional_office")
	private String ro;
	@NotNull
	@Column(name="lin")
	private Long lin;
	@NotNull
	@Column(name="user_id")
	private String userid;
	@NotNull
	@Column(name="signatory")
	private String signatory;
	@Column(name="email_id")
	private String emailId;
	@Column(name="mobile_no")
	private String mobileNo;
	@NotNull
	@Column(name="password")
	private String password;
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
	    @JoinColumn(name="company_id")
	    private Company company;


	public ESI() {
		super();
	}


	public ESI(Long id, @NotNull Long employerCodeNo, @NotNull String employerName, @NotNull String ro,
			@NotNull Long lin, @NotNull String userid, @NotNull String signatory, String emailId, String mobileNo,
			@NotNull String password, String createdBy, String updatedBy, LocalDateTime createdDate,
			LocalDateTime updatedDate, boolean active, Company company) {
		super();
		this.id = id;
		this.employerCodeNo = employerCodeNo;
		this.employerName = employerName;
		this.ro = ro;
		this.lin = lin;
		this.userid = userid;
		this.signatory = signatory;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.password = password;
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


	public Long getEmployerCodeNo() {
		return employerCodeNo;
	}


	public void setEmployerCodeNo(Long employerCodeNo) {
		this.employerCodeNo = employerCodeNo;
	}


	public String getEmployerName() {
		return employerName;
	}


	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}


	public String getRo() {
		return ro;
	}


	public void setRo(String ro) {
		this.ro = ro;
	}


	public Long getLin() {
		return lin;
	}


	public void setLin(Long lin) {
		this.lin = lin;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getSignatory() {
		return signatory;
	}


	public void setSignatory(String signatory) {
		this.signatory = signatory;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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
