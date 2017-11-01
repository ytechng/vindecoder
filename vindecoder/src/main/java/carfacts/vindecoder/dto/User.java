package carfacts.vindecoder.dto;

import javax.print.attribute.standard.DateTimeAtCreation;

public class User {

	/*
	 * Private properties
	 */
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNo;
	private String companyName;
	private String companyAddress;
	private String role = "business";
	private String password;
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
