package com.member;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableEurekaClient
//startup
public class MemberRegistrationPortalApplication {
	/*
	 * logger
	 */
	private static Logger logger = LogManager.getLogger(MemberRegistrationPortalApplication.class);

	/*
	 * default constructor
	 */
	public MemberRegistrationPortalApplication() {}
	

	/*
	 * Main Method
	 */
	public static void main(String[] args) {
		logger.info("Startup of the Application");
		SpringApplication.run(MemberRegistrationPortalApplication.class, args);

	}

}
