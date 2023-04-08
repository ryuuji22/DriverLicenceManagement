package com.mitocode.licensewriteservice.application.command.delete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.licensewriteservice.domain.services.validations.IValidationActionInterface;
import com.mitocode.licensewriteservice.domain.services.validations.ValidarLicenciaExisteBySolcitante;

import io.jkratz.mediator.core.CommandHandler;
import io.jkratz.mediator.core.Mediator;

@Component
public class EliminarLicenciaCommandHandler implements CommandHandler<EliminarLicenciaCommand> {

	@Autowired
	private Mediator mediator;

	@Autowired
	@Qualifier("deleteValidationAction")
	private IValidationActionInterface action;

	@Override
	@Transactional
	public void handle(EliminarLicenciaCommand command) {
		var validarLicencia = new ValidarLicenciaExisteBySolcitante(30, command.getDni(), action,Boolean.TRUE);
		this.mediator.dispatch(validarLicencia);

	}

}
