package org.khmeracademy.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilterUser {
	@JsonProperty("USER_NAME")
	private String user_name;
	@JsonProperty("GENDER")
	private String gender;
	@JsonProperty("REGISTERED_DATE")
	private String register_date;
	@JsonProperty("ROLE")
	private String role;
	
	
	public FilterUser() {
		user_name = null;
		gender = null;
		register_date = null;
		role = null;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
