package com.mitocode.licensewriteservice.domain.services.validations;

import io.jkratz.mediator.core.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ValidarLicenciaExisteBySolcitante implements Command {
	
	private Integer diasVigencia;
	
	private String dni;
	
	private IValidationActionInterface action;
	
	private Boolean postException;


}
