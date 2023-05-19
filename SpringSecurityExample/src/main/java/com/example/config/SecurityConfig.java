package com.example.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/balance").authenticated()
		.antMatchers("/statement").authenticated()
		.antMatchers("/loan").authenticated()
		.antMatchers("/home").permitAll()
		.antMatchers("/contact")
		.permitAll()
		.and().formLogin()
		.and().httpBasic()
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		.and()
		.exceptionHandling()
		.accessDeniedPage("/denied")
		;
	}
}
