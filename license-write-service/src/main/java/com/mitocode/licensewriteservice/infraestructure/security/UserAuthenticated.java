package com.mitocode.licensewriteservice.infraestructure.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.mitocode.licensewriteservice.domain.interfaces.services.IUserAuthenticated;

@Component
public class UserAuthenticated implements IUserAuthenticated {

	@Override
	public String getCurrentUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		return authentication.getName();
	}

}
