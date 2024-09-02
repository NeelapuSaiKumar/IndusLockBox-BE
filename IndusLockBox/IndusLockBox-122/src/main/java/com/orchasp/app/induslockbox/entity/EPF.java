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
@Table(name = "epf_table")
public class EPF {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "epf_id")
	private Long id;
	@NotNull
	@Column(name = "est_id")
	private String estid;
	@NotNull
	@Column(name = "lin")
	private Long lin;
	@NotNull
	@Column(name = "mobile_no")
	private String mobileNo;
	@NotNull
	@Column(name = "email_id")
	private String emailId;
	@NotNull
	@Column(name = "pan_no")
	private String panno;
	@NotNull
	@Column(name = "nic_code")
	private String niccode;
	@NotNull
	@Column(name = "pf_office_address")
	private String pfOfficeAddress;
	@NotNull
	@Column(name="user_id")
	private String userid;
	@NotNull
	@Column(name="password")
	private String password;
	
	@NotNull
	@Column(name = "signatory")
	private String signatory;
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

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public EPF() {
		super();
	}
	public EPF(Long id, @NotNull String estid, @NotNull Long lin, @NotNull String mobileNo, @NotNull String emailId,
			@NotNull String panno, @NotNull String niccode, @NotNull String pfOfficeAddress, @NotNull String userid,
			@NotNull String password, @NotNull String signatory, String createdBy, String updatedBy,
			LocalDateTime createdDate, LocalDateTime updatedDate, boolean active, Company company) {
		super();
		this.id = id;
		this.estid = estid;
		this.lin = lin;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.panno = panno;
		this.niccode = niccode;
		this.pfOfficeAddress = pfOfficeAddress;
		this.userid = userid;
		this.password = password;
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

	public String getEstid() {
		return estid;
	}

	public void setEstid(String estid) {
		this.estid = estid;
	}

	public Long getLin() {
		return lin;
	}

	public void setLin(Long lin) {
		this.lin = lin;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public String getNiccode() {
		return niccode;
	}

	public void setNiccode(String niccode) {
		this.niccode = niccode;
	}

	public String getPfOfficeAddress() {
		return pfOfficeAddress;
	}

	public void setPfOfficeAddress(String pfOfficeAddress) {
		this.pfOfficeAddress = pfOfficeAddress;
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
