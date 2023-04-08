package com.mitocode.licensewriteservice.domain.services.reads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mitocode.licensewriteservice.domain.interfaces.services.IUserAuthenticated;

import io.jkratz.mediator.core.RequestHandler;

@Component
public class ReadUserAuthenticatedServiceHandler implements RequestHandler<ReadUserAuthenticatedService, String> {

	@Autowired
	private IUserAuthenticated userAuthenticated;

	@Override
	public String handle(ReadUserAuthenticatedService service) {

		return userAuthenticated.getCurrentUser();
	}

}
