package org.khmeracademy.services.implement;

import java.util.ArrayList;

import org.khmeracademy.entities.Role;
import org.khmeracademy.entities.User;
import org.khmeracademy.repositories.UserRepository;
import org.khmeracademy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService{
	@Autowired 
	private UserRepository userRepository;
	@Override
	public User findUserByEmail(String userEmail) 
	{
		return userRepository.findUserByEmail(userEmail);
	}
	@Override
	public ArrayList<Role> findRolesByRoleId(int role_id) 
	{
		return userRepository.findRolesByRoleId(role_id);
	}
}
