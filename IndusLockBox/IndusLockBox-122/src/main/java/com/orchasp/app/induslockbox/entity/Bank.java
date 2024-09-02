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
@Table(name="bank_table")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bank_id")
	private Long id;
	@NotNull
	@Column(name="account_holder_name")
	private String accountHolderName;
	@NotNull
	@Column(name="account_number")
	private Long bankAccountNumber;
	@NotNull
	@Column(name="ifsc_code")
	private String ifsccode;
	@NotNull
	@Column(name="mirc_code")
	private String mirccode;
	@NotNull
	@Column(name="bank_name")
	private String bankName;
	@NotNull
	@Column(name="bank_branch")
	private String branch;
	@NotNull
	@Column(name="transaction_password")
	private String transactionpassword;
	@NotNull
	@Column(name="account_type")
	private String accountType;
	@NotNull
	@Column(name="email_id")
	private String emailId;
	@NotNull
	@Column(name="mobile_no")
	private Long mobileNo;
	@Column(name="primary_signatory")
	private String primarySignatory;
	@Column(name="secondary_signatory")
	private String secondarySignatory;
	@NotNull
	@Column(name="user_id")
	private String userid;
	@NotNull
	@Column(name="login_password")
    private String loginpassword;

	
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

	public Bank() {
		super();
	}

	public Bank(Long id, @NotNull String accountHolderName, @NotNull Long bankAccountNumber, @NotNull String ifsccode,
			@NotNull String mirccode, @NotNull String bankName, @NotNull String branch,
			@NotNull String transactionpassword, @NotNull String accountType, @NotNull String emailId,
			@NotNull Long mobileNo, String primarySignatory, String secondarySignatory, @NotNull String userid,
			@NotNull String loginpassword,  String createdBy, String updatedBy,
			LocalDateTime createdDate, LocalDateTime updatedDate, boolean active, Company company) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.bankAccountNumber = bankAccountNumber;
		this.ifsccode = ifsccode;
		this.mirccode = mirccode;
		this.bankName = bankName;
		this.branch = branch;
		this.transactionpassword = transactionpassword;
		this.accountType = accountType;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.primarySignatory = primarySignatory;
		this.secondarySignatory = secondarySignatory;
		this.userid = userid;
		this.loginpassword = loginpassword;
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

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Long getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(Long bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getMirccode() {
		return mirccode;
	}

	public void setMirccode(String mirccode) {
		this.mirccode = mirccode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getTransactionpassword() {
		return transactionpassword;
	}

	public void setTransactionpassword(String transactionpassword) {
		this.transactionpassword = transactionpassword;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPrimarySignatory() {
		return primarySignatory;
	}

	public void setPrimarySignatory(String primarySignatory) {
		this.primarySignatory = primarySignatory;
	}

	public String getSecondarySignatory() {
		return secondarySignatory;
	}

	public void setSecondarySignatory(String secondarySignatory) {
		this.secondarySignatory = secondarySignatory;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLoginpassword() {
		return loginpassword;
	}

	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
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
