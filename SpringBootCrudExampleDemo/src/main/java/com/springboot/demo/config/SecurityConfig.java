package com.springboot.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication()
			.withUser("employee").password("employee123").roles("EMPLOYEE")
			.and()
			.withUser("admin").password("admin123").roles("ADMIN");
			
	}
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http.httpBasic()
			.and()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST,"/employee").hasRole("EMPLOYEE")
			.antMatchers(HttpMethod.DELETE,"/employee/**").hasRole("ADMIN")
			.antMatchers("/**").hasAnyRole("EMPLOYEE","ADMIN")
			.and()
			.formLogin();
		http.csrf().disable();
	}
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
}