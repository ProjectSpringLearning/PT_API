package org.khmeracademy.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.khmeracademy.entities.Role;
import org.khmeracademy.entities.User;
import org.khmeracademy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("CustomUserDetailService")
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		User user = userService.findUserByEmail(email);
		if(user == null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("User not found");
		}
		System.out.println(user.getRoles().size());
		for (Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole_name()));
			System.out.println(role.getRole_name());
		}
//		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//		true, true, true, true, getGrantedAuthorities(user));
		
		System.out.println(user.getRoles().get(0).getRole_name());
		
		return user;
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		try{
			for (Role role : user.getRoles()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRole_name()));
				System.out.println(role.getRole_name());
			}
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			System.out.print("authorities :" + authorities);
		}catch(Exception ex){
			ex.printStackTrace();
		}
			return authorities;
	}
	
	

}
