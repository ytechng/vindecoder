package carfacts.vindecoder.dto;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

//import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "vd_users")
public class User implements Serializable {
	// To store anything inside flow scope from webflow - implement Seriliazable
	// interface

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

	@Column(name = "first_name", nullable = false, length = 30)
	@NotBlank(message = "Please enter first name!")
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 30)
	@NotBlank(message = "Please enter your last name!")
	private String lastName;

	@Column(name = "email", nullable = false, unique = true, length = 100)
	@NotBlank(message = "Please enter your email address!")
	@Email(message = "Please enter a valid email address!")
	private String email;

	@Column(name = "phone_no", nullable = false, length = 11)
	@NotBlank(message = "Please enter your contact number!")
	private String phoneNo;

	@Column(name = "company_name", length = 100)
	@NotBlank(message = "Please enter your company name!")
	private String companyName;

	@Column(name = "company_address", length = 100)
	@NotBlank(message = "Please enter your company address!")
	private String companyAddress;

	@Column(length = 10)
	private String role = "business";

	@Column(nullable = false, length = 60)
	@NotBlank(message = "Please enter your password!")
	private String password;

	@Column(name = "enabled")
	private boolean active = true;
	
	//columnDefinition = "DATE DEFAULT CURRENT_DATE"
	@Column(name = "reg_date", nullable = true)
	private Date regDate;
	
	@Column(nullable = true)
	private int credit = 0;

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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {		
		this.regDate = regDate;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public void setCredit(int qty) {
		this.credit = qty;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", companyName=" + companyName + ", companyAddress=" + companyAddress
				+ ", role=" + role + ", password=" + password + ", active=" + active + ", regDate=" + regDate
				+ ", credit=" + credit + "]";
	}

}