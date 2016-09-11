package org.khmeracademy.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.khmeracademy.entities.Role;
import org.khmeracademy.entities.User;
import org.khmeracademy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AuthenticationController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       if (auth != null){    
          new SecurityContextLogoutHandler().logout(request, response, auth);
       }
       return "redirect:/login?logout";
    }
	
	@RequestMapping("/login")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping("/getuser")
	@ResponseBody
	public User getUser(){
//		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
//		User user = (User) authentication.getPrincipal();
//		System.out.println(user.getUsername()+" | "+user.getId() + " | " + user.getRoles().get(0).getRole_name() );
		return userService.findUserByEmail("string");
	}
	
	@RequestMapping("/getrole")
	@ResponseBody
	public ArrayList<Role> getRole(){
		
		return userService.findRolesByRoleId(1);
	}
	
}
