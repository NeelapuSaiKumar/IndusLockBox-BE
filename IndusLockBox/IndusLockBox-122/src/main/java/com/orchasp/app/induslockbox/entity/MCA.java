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
public class MCA {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mca_id")
	private Long id;
	@NotNull
	@Column(name="cin")
	private String cin;
	@NotNull
	@Column(name="company_name")
	private String companyName;
	@NotNull
	@Column(name="roc_name")
	private String rocName;
	@Column(name="registration_name")
	private String registrationNo;
	@Column(name="date_of_incorportion")
	private String dateOfIncorporation;
	@Column(name="email_id")
	private String email;
	@Column(name="registered_address")
	private String registeredAddress;
	@Column(name="stock_exchanges")
	private String stockExchanges;
	@Column(name="class_of_company")
	private String classOfCompany;
	@Column(name="authorised_capital")
	private String authorisedCapital;
	@Column(name="paid_up_capital")
	private String paidUpCapital;
	@Column(name="telephone")
	private Long telephone;
	@Column(name="mobile_no")
	private Long mobileNo;
	@Column(name="v2_login_id")
	private String v2loginid;
	@Column(name="v3_login_id")
	private String v3loginid;
	@Column(name="v2_email_id")
	private String v2emailId;
	@Column(name="v3_email_id")
	private String v3emailId;
	@Column(name="v2_password")
	private String v2password;
	@Column(name="v3_password")
	private String v3password;
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
     public MCA() {
    	 super();
     }

	public MCA(Long id, @NotNull String cin, @NotNull String rocName, String registrationNo, String dateOfIncorporation,
			String email, String registeredAddress, String stockExchanges, String classOfCompany,
			String authorisedCapital, String paidUpCapital, Long telephone, Long mobileNo, String v2loginid,
			String v3loginid, String v2emailId, String v3emailId, String v2password, String v3password,
			String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate, boolean active,@NotNull String companyName,
			Company company) {
		super();
		this.id = id;
		this.cin = cin;
		this.rocName = rocName;
		this.registrationNo = registrationNo;
		this.dateOfIncorporation = dateOfIncorporation;
		this.email = email;
		this.registeredAddress = registeredAddress;
		this.stockExchanges = stockExchanges;
		this.classOfCompany = classOfCompany;
		this.authorisedCapital = authorisedCapital;
		this.paidUpCapital = paidUpCapital;
		this.telephone = telephone;
		this.mobileNo = mobileNo;
		this.v2loginid = v2loginid;
		this.v3loginid = v3loginid;
		this.v2emailId = v2emailId;
		this.v3emailId = v3emailId;
		this.v2password = v2password;
		this.v3password = v3password;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.active = active;
		this.companyName = companyName;
		this.company = company;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public String getRocName() {
		return rocName;
	}


	public void setRocName(String rocName) {
		this.rocName = rocName;
	}


	public String getRegistrationNo() {
		return registrationNo;
	}


	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}


	public String getDateOfIncorporation() {
		return dateOfIncorporation;
	}


	public void setDateOfIncorporation(String dateOfIncorporation) {
		this.dateOfIncorporation = dateOfIncorporation;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRegisteredAddress() {
		return registeredAddress;
	}


	public void setRegisteredAddress(String registeredAddress) {
		this.registeredAddress = registeredAddress;
	}


	public String getStockExchanges() {
		return stockExchanges;
	}


	public void setStockExchanges(String stockExchanges) {
		this.stockExchanges = stockExchanges;
	}


	public String getClassOfCompany() {
		return classOfCompany;
	}


	public void setClassOfCompany(String classOfCompany) {
		this.classOfCompany = classOfCompany;
	}


	public String getAuthorisedCapital() {
		return authorisedCapital;
	}


	public void setAuthorisedCapital(String authorisedCapital) {
		this.authorisedCapital = authorisedCapital;
	}


	public String getPaidUpCapital() {
		return paidUpCapital;
	}


	public void setPaidUpCapital(String paidUpCapital) {
		this.paidUpCapital = paidUpCapital;
	}


	public Long getTelephone() {
		return telephone;
	}


	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}


	public Long getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getV2loginid() {
		return v2loginid;
	}


	public void setV2loginid(String v2loginid) {
		this.v2loginid = v2loginid;
	}


	public String getV3loginid() {
		return v3loginid;
	}


	public void setV3loginid(String v3loginid) {
		this.v3loginid = v3loginid;
	}


	public String getV2emailId() {
		return v2emailId;
	}


	public void setV2emailId(String v2emailId) {
		this.v2emailId = v2emailId;
	}


	public String getV3emailId() {
		return v3emailId;
	}


	public void setV3emailId(String v3emailId) {
		this.v3emailId = v3emailId;
	}


	public String getV2password() {
		return v2password;
	}


	public void setV2password(String v2password) {
		this.v2password = v2password;
	}


	public String getV3password() {
		return v3password;
	}


	public void setV3password(String v3password) {
		this.v3password = v3password;
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}
