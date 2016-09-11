package org.khmeracademy.entities;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class Role implements Serializable, GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String role_name;
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return role_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
