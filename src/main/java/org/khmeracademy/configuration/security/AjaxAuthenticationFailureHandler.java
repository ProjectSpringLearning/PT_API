package org.khmeracademy.configuration.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component("ajaxAuthenticationFailureHandler")
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, 
																		HttpServletResponse response,
																		AuthenticationException auth)
																		throws IOException, ServletException {
		
		System.out.println("AUTH "+ auth);
		response.getWriter().println(auth.getMessage());
		response.getWriter().flush();
	}
}
