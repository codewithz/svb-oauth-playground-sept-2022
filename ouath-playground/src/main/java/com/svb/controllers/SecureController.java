package com.svb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

	@GetMapping("/welcome")
	public String getSecuredFile() {
		return "secure.html";
	}
}
