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
@Table(name = "incometax_table")
public class IncomeTax {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "incometax_id")
	private Long id;
	@NotNull
	@Column(name = "pan_number")
	private String panNumber;
	@NotNull
	@Column(name = "name")
	private String name;
	@NotNull
	@Column(name = "issued_date(pan)")
	private String panIssuedDate;
	@NotNull
	@Column(name = "incorporation_date")
	private String incorporationDate;
	@NotNull
	@Column(name = "primary_mobile")
	private Long primaryMobile;
	@NotNull
	@Column(name = "secondary_mobile")
	private Long secondaryMobile;
	@NotNull
	@Email
	@Column(name = "primary_email")
	private Long primaryEmail;
	@NotNull
	@Email
	@Column(name = "secondary_email")
	private Long secondaryEmail;
	@NotNull
	@Column(name = "tds")
	private Double tds;
	@NotNull
	@Column(name = "user_id")
	private String userid;
	@NotNull
	@Column(name = "password")
	private String password;
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

	public IncomeTax() {
		super();
	}

	public IncomeTax(Long id, @NotNull String panNumber, @NotNull String name, @NotNull String panIssuedDate,
			@NotNull String incorporationDate, @NotNull Long primaryMobile, @NotNull Long secondaryMobile,
			@NotNull Long primaryEmail, @NotNull Long secondaryEmail, @NotNull String userid, @NotNull String password,
			String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate, boolean active,
			Company company) {
		super();
		this.id = id;
		this.panNumber = panNumber;
		this.name = name;
		this.panIssuedDate = panIssuedDate;
		this.incorporationDate=incorporationDate;
		this.primaryMobile = primaryMobile;
		this.secondaryMobile = secondaryMobile;
		this.primaryEmail = primaryEmail;
		this.secondaryEmail = secondaryEmail;
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

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPanIssuedDate() {
		return panIssuedDate;
	}

	public void setPanIssuedDate(String panIssuedDate) {
		this.panIssuedDate = panIssuedDate;
	}

	

	public String getIncorporationDate() {
		return incorporationDate;
	}

	public void setIncorporationDate(String incorporationDate) {
		this.incorporationDate = incorporationDate;
	}



	public Long getPrimaryMobile() {
		return primaryMobile;
	}

	public void setPrimaryMobile(Long primaryMobile) {
		this.primaryMobile = primaryMobile;
	}

	public Long getSecondaryMobile() {
		return secondaryMobile;
	}

	public void setSecondaryMobile(Long secondaryMobile) {
		this.secondaryMobile = secondaryMobile;
	}

	public Long getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(Long primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public Long getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(Long secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
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

	public Double getTds() {
		return tds;
	}

	public void setTds(Double tds) {
		this.tds = tds;
	}

	public String getSignatory() {
		return signatory;
	}

	public void setSignatory(String signatory) {
		this.signatory = signatory;
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
