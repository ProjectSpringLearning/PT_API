package org.khmeracademy.repositories;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.khmeracademy.entities.Role;
import org.khmeracademy.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
	
	/*
	 * USER CUSTOME LOGIN BASIC SECURITY 
	 */

	@Select("SELECT "
			+ " id,"
			+ " username,"
			+ " password,"
			+ " email,"
			+ "  role_id "
			+ "  FROM "
			+ "  users "
			+ "  WHERE "
			+ "  email=#{userEmail}")
	@Results(value = {
			@Result(property = "roles", column = "role_id",
				many = @Many(select = "findRolesByRoleId")
			)
	})
	public User findUserByEmail(@Param("userEmail") String userEmail);

	@Select("SELECT"
			+ "  id,"
			+ "  role_name"
			+ "  FROM"
			+ "  roles"
			+ "  WHERE "
			+ "  id=#{role_id}")
	@Results(value = {
		@Result(property="id" , column="id"),
		@Result(property="role_name" , column="role_name")
	})
	public ArrayList<Role> findRolesByRoleId( int role_id);
	
	
}

