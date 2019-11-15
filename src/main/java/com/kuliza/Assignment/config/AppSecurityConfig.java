package com.kuliza.Assignment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	PasswordEncoder passwordEncoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic().and()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/getempdetail").hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, "/postemployee").hasRole("USER")
        .antMatchers(HttpMethod.PUT, "/updateemp/{id}").hasRole("USER")
        .antMatchers(HttpMethod.DELETE, "/delete/{id}").hasRole("ADMIN")
		.and().csrf().disable().formLogin().disable();

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("1234")).roles("ADMIN")
		.and().withUser("user").password(passwordEncoder.encode("user")).roles("USER");
	}
}
