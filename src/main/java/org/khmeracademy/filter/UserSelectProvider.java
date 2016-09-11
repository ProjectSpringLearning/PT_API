package org.khmeracademy.filter;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

public class UserSelectProvider {
	/*select and search user detail*/
	public static String  findAndManagementUser(Map<String,Object> param){
		FilterUser  filter = (FilterUser) param.get("filter");
		String sql = new SQL(){
			{
			/*	SELECT("U.user_id,"
						+" U.user_name,"
						+" U.gender,"
						+" U.email,"
						+" U.password,"
						+" U.registered_date,"
						+" U.photo,"
						+" U.description,"
						+" U.status,"
						+" UT.role_name");
				FROM("ksl_user U");
				INNER_JOIN("ksl_user_type UT ON U.role_id = UT.role_id");
				WHERE("U.status=1");*/
					/*if (filter.getDoc_id()!=0) {
						WHERE("D.doc_id = CONVERT(INT, #{filter.doc_id})");
					}*/
					/*if (filter.getUser_name() != null) {
						WHERE("LOWER(U.user_name) LIKE LOWER('%' || #{filter.user_name} || '%')");
					}
					if(filter.getGender() != null){
						WHERE("LOWER(U.gender) LIKE LOWER('%' || #{filter.gender} || '%')");
					}
					if(filter.getRegister_date() != null){
						WHERE("LOWER(U.registered_date) LIKE LOWER('%' || #{filter.register_date} || '%')");
					}
					if(filter.getRole() != null){
						WHERE("LOWER(UT.role_name) LIKE LOWER('%' || #{filter.role} || '%')");
					}
					ORDER_BY("U.user_id DESC OFFSET #{pagination.offset} LIMIT #{pagination.limit}");*/
			}
		}.toString();
		return sql;
	}

}
