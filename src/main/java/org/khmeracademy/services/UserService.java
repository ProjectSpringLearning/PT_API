package org.khmeracademy.services;

import java.util.ArrayList;


import org.khmeracademy.entities.Role;
import org.khmeracademy.entities.User;

public interface UserService {
	
	 
	public User findUserByEmail(String userEmail);
	public ArrayList<Role> findRolesByRoleId(int role_id);
}
