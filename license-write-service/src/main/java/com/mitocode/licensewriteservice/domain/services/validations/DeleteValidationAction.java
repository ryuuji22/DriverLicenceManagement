package com.mitocode.licensewriteservice.domain.services.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mitocode.licensewriteservice.application.services.messages.publish.PublishLicenciaDeleted;
import com.mitocode.licensewriteservice.domain.entities.Licencia;
import com.mitocode.licensewriteservice.domain.enums.ActionsEnum;
import com.mitocode.licensewriteservice.domain.interfaces.repositories.ILicenciaRepository;
import com.mitocode.licensewriteservice.domain.interfaces.services.ISendAuditEventService;

import io.jkratz.mediator.core.Mediator;

@Component(value = "deleteValidationAction")
public class DeleteValidationAction implements IValidationActionInterface {

	@Autowired
	private ILicenciaRepository licenciaRepository;
	@Autowired
	private Mediator mediator;
	@Autowired
	private ISendAuditEventService auditService;

	@Override
	public void doAction(Licencia licencia) {
		licenciaRepository.delete(licencia);
		this.mediator.dispatchAsync(new PublishLicenciaDeleted(licencia.getId()));
		this.enviarEvento(licencia);
	}
	
	private void enviarEvento(Licencia licenciaDB) {
		auditService.sendAuditEvent(licenciaDB, ActionsEnum.DELETE.getAction());
		
	}

}
