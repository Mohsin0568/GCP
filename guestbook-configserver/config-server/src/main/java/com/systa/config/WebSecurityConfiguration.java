package com.systa.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		// below URL will be accessed by app engine for app health check.
		http.authorizeRequests().antMatchers("/_ah/start").permitAll();
	}
}
