package com.obsquara.pages;

public class DeliveryBoyUser {
	private String name;
	private String email;
	private String phonenumber;
	private String address;
	private String username;
	private String password;

	public String getName() {
		return name;
	}

	public DeliveryBoyUser(String name, String email, String phonenumber, String address, String username,
			String password) {
		super();
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.username = username;
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
