package com.mitocode.licensewriteservice.domain.services.validations;

import com.mitocode.licensewriteservice.domain.entities.Licencia;

public interface IValidationActionInterface {

	void doAction(Licencia licencia);

}
