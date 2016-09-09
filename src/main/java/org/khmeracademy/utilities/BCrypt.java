package org.khmeracademy.utilities;

import java.util.Base64;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BCrypt {
	@JsonProperty("PASSWORD")
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BCrypt() {
		String userInputPwd = "123456";
		System.out.println(new BCryptPasswordEncoder().encode(userInputPwd));
		if(new BCryptPasswordEncoder().matches(userInputPwd, "$2a$10$XPWAbe7pI9n2rpd9GuAM2O13UT4BwtHOgkGV4z3C.svXp0tl1tLWC")){
			System.out.println("SUCCESS");
		}else{
			System.out.println("FAILURE");
		}
	}
	
	public static String BCryptPassword(String password)
	{	
		return new BCryptPasswordEncoder().encode(password);
	}
	/*public static void Base64Test(){
		
		System.out.println(Base64.getEncoder().encodeToString("123456890".getBytes()));
		if(Base64.getEncoder().encodeToString("123456890".getBytes()).equals("MTIzNDU2ODkw")){
			System.out.println("SUCCESS");
		}else{
			System.out.println("FAILURE");
		}
	}*/
	/*public static void main(String[] args) {
		new BCrypt();
	}*/
}
