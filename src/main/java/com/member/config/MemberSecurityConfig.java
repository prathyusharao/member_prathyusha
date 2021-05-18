package com.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class MemberSecurityConfig extends WebSecurityConfigurerAdapter {
	/*
	 * role based authentication
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("prathyusha").password("prathyusha").roles("admin");
	}

	/*
	 * security implemented for all the methods
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("*")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		/*http.authorizeRequests().antMatchers("/register/**").hasAnyRole("admin").anyRequest().fullyAuthenticated().and()
				.httpBasic();*/

	}

	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
