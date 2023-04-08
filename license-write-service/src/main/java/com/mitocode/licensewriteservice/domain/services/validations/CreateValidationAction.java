package com.mitocode.licensewriteservice.domain.services.validations;

import org.springframework.stereotype.Component;

import com.mitocode.licensewriteservice.domain.entities.Licencia;
import com.mitocode.licensewriteservice.domain.exceptions.ApplicationDomainException;

@Component(value = "createValidationAction")
public class CreateValidationAction implements IValidationActionInterface {

	@Override
	public void doAction(Licencia licencia) {
		throw new ApplicationDomainException(
				"Ya tiene una licencia con rut: " + licencia.getRut() + ", mas tiene que renovarla");

	}

}
