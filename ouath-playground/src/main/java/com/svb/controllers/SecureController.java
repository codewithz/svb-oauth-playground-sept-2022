package com.svb.controllers;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

	@GetMapping("/welcome")
	public String getSecuredFile(OAuth2AuthenticationToken token) {
		System.out.println(token.getPrincipal());
		return "secure.html";
	}
}
