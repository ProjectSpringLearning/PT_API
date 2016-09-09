package org.khmeracademy.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	@Qualifier(value="ajaxAuthenticationSuccessHandler")
	private AjaxAuthenticationSuccessHandler ajaxAuthenticationSuccessHandler;
	
	@Autowired
	@Qualifier(value="ajaxAuthenticationFailureHandler")
	private AjaxAuthenticationFailureHandler ajaxAuthenticationFailureHandler;
	
	@Autowired
	@Qualifier("customUserDetailService")
	private UserDetailsService userDetailsService;
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		/*api developer only*/ 
		auth.inMemoryAuthentication().withUser("api").password("api").roles("DEVELOPER");
	
	
		auth.userDetailsService(userDetailsService);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*mapping all input */
		http
			.authorizeRequests()
			//.antMatchers("/","/home","/index","/developer","/admin","/user").permitAll()
			.antMatchers("/api/**").hasAnyRole("DEVELOPER");
		
		http
			.formLogin()
			.loginPage("/")
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll()
			.failureHandler(ajaxAuthenticationFailureHandler)
			.successHandler(ajaxAuthenticationSuccessHandler);
		/*logout*/
		http.logout().logoutUrl("/developer/logout");
		/*not close connection*/
		http.csrf().disable();
		/*go to access deny*/
		http.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	
	/*@Autowired
	@Qualifier("customUserDetailService")
	private UserDetailsService userDetailsService;
	
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user")
			.password("123")
			.roles("USER");
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password("123")
			.roles("ADMIN");
		auth.inMemoryAuthentication()
			.withUser("dba")
			.password("123")
			.roles("USER" , "ADMIN" , "DBA");
		
		
		auth.userDetailsService(userDetailsService);
		
		
	}
	*/
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/" , "/home").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasRole("USER")
			.antMatchers("/dba/**").hasAnyRole("USER","ADMIN","DBA");
		http
			.formLogin()
			.loginPage("/login")
			.usernameParameter("username")
			.passwordParameter("password")
			.permitAll();
		http.csrf().disable();
		http.exceptionHandling().accessDeniedPage("/access-denied");
		
		
	}*/
	
}
