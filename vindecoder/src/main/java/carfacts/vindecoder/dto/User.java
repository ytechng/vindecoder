package carfacts.vindecoder.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCreation;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User implements Serializable { 
	// To store anything inside flow scope from webflow - implement Seriliazable interface

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Private properties
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	@NotBlank(message = "Please enter first name!")
	private String firstName;
	
	@Column(name = "last_name")
	@NotBlank(message = "Please enter last name!")
	private String lastName;
	
	@NotBlank(message = "Please enter email address!")
	private String email;
	
	@Column(name = "phone_no")
	@NotBlank(message = "Please enter contact number!")
	private String phoneNo;
	
	@Column(name = "company_name")
	@NotBlank(message = "Please enter company name!")
	private String companyName;
	
	@Column(name = "company_address")
	@NotBlank(message = "Please enter company address!")
	private String companyAddress;
	
	private String role = "business";
	
	@NotBlank(message = "Please enter password!")
	private String password;
	
	@Column(name = "reg_date")
	private DateTimeAtCreation regDate;
	
	private boolean enabled = true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DateTimeAtCreation getRegDate() {
		return regDate;
	}

	public void setRegDate(DateTimeAtCreation regDate) {
		this.regDate = regDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", companyName=" + companyName + ", companyAddress=" + companyAddress
				+ ", role=" + role + ", password=" + password + ", regDate=" + regDate + ", enabled=" + enabled + "]";
	}

}
