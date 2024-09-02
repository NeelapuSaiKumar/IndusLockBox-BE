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
@Table(name="professionaltax_table")
public class ProfessionalTax {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="pt_id")
	private Long id;
	@NotNull
	@Column(name="ptin_sal")
	private Long ptinSal;
	@NotNull
	@Column(name="ptin_com")
	private Long ptinCom;
	@NotNull
	@Column(name="tax_division")
	private String taxDivision;
	@NotNull
	@Column(name="tax_circle")
	private String taxCircle;
	@NotNull
	@Column(name="mobile_no")
	private Long mobileNo;
	@NotNull
	@Column(name="email")
	private String email;
	@NotNull
	@Column(name="date_of_enrollment")
	private String dateOfEnrollment;
	@NotNull
	@Column(name="userid")
	private String userid;
	@NotNull
	@Column(name="password")
	private String password;
	@NotNull
	@Column(name="signature")
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

	public ProfessionalTax() {
		super();
	}

	public ProfessionalTax(Long id, @NotNull Long ptinSal, @NotNull Long ptinCom, @NotNull String taxDivision,
			@NotNull String taxCircle, @NotNull Long mobileNo, @NotNull String email,
			@NotNull String dateOfEnrollment, @NotNull String userid, @NotNull String password, String createdBy,
			String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate, boolean active, Company company) {
		super();
		this.id = id;
		this.ptinSal = ptinSal;
		this.ptinCom = ptinCom;
		this.taxDivision = taxDivision;
		this.taxCircle = taxCircle;
		this.mobileNo = mobileNo;
		this.email = email;
		this.dateOfEnrollment = dateOfEnrollment;
		this.userid = userid;
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

	public Long getPtinSal() {
		return ptinSal;
	}

	public void setPtinSal(Long ptinSal) {
		this.ptinSal = ptinSal;
	}

	public Long getPtinCom() {
		return ptinCom;
	}

	public void setPtinCom(Long ptinCom) {
		this.ptinCom = ptinCom;
	}

	public String getTaxDivision() {
		return taxDivision;
	}

	public void setTaxDivision(String taxDivision) {
		this.taxDivision = taxDivision;
	}

	public String getTaxCircle() {
		return taxCircle;
	}

	public void setTaxCircle(String taxCircle) {
		this.taxCircle = taxCircle;
	}


	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfEnrollment() {
		return dateOfEnrollment;
	}

	public void setDateOfEnrollment(String dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
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