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
@Table(name="gst_table")
public class GST {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="gst_id")
	private Long id;
	@NotNull
	@Column(name="gst_number")
	private String gstNumber;
	@NotNull
	@Column(name="user_id")
	private String userid;
	@NotNull
	@Column(name="password")
	private String password;
	@NotNull
	@Email
	@Column(name="email")
	private String email;
	@NotNull
	@Column(name="mobile_no")
	private String mobileno;
	@NotNull
	@Column(name="address")
	private String address;
	@NotNull
	@Column(name="signatory")
	private String signatory;
	@NotNull
	@Column(name="state")
	private String state;
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

	public GST() {
		super();
	}

	public GST(Long id, @NotNull String gstNumber, @NotNull String userid, @NotNull String password,
			@NotNull @Email String email, @NotNull String mobileno,@NotNull String signatory, @NotNull String address, @NotNull String state,
			String createdBy, String updatedBy, LocalDateTime createdDate, LocalDateTime updatedDate, boolean active,
			Company company) {
		super();
		this.id = id;
		this.gstNumber = gstNumber;
		this.userid = userid;
		this.password = password;
		this.email = email;
		this.mobileno = mobileno;
		this.signatory=signatory;
		this.address = address;
		this.state = state;
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

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSignatory() {
		return signatory;
	}

	public void setSignatory(String signatory) {
		this.signatory = signatory;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
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
