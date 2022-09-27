package com.svb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.oauth2Login();
	}
	
	
	private ClientRegistration clientRegistration() {
		
		ClientRegistration registration= CommonOAuth2Provider.GITHUB
										.getBuilder("github")
										.clientId("ee2ad6dc257248a3f5d1")
										.clientSecret("e64c9ab2f9c75d8aedb194cc052b3039a339fe83")
										.build();
		
		return registration;
	}
	
	@Bean
	public ClientRegistrationRepository clientRepository() {
		
		ClientRegistration registration=clientRegistration();
		InMemoryClientRegistrationRepository repository=
						new InMemoryClientRegistrationRepository(registration);
		
		return repository;
	
	}

}
