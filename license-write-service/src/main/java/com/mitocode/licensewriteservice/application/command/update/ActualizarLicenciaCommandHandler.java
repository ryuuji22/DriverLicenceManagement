package com.mitocode.licensewriteservice.application.command.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.licensewriteservice.domain.entities.Solicitante;
import com.mitocode.licensewriteservice.domain.enums.ActionsEnum;
import com.mitocode.licensewriteservice.domain.exceptions.ApplicationDomainException;
import com.mitocode.licensewriteservice.domain.interfaces.repositories.ILicenciaRepository;
import com.mitocode.licensewriteservice.domain.interfaces.repositories.ISolicitanteRepository;
import com.mitocode.licensewriteservice.domain.interfaces.services.ISendAuditEventService;

import io.jkratz.mediator.core.CommandHandler;

@Component
public class ActualizarLicenciaCommandHandler implements CommandHandler<ActualizarLicenciaCommand> {

	@Autowired
	private ILicenciaRepository licenciaRepository;

	@Autowired
	private ISolicitanteRepository solicitanteRepository;
	
	@Autowired
	private ISendAuditEventService auditService;

	@Override
	@Transactional
	public void handle(ActualizarLicenciaCommand command) {
		var solicitante=this.getSolicitante(command);
		licenciaRepository.update(solicitante);
		this.enviarEvento(solicitante);

	}

	private Solicitante getSolicitante(ActualizarLicenciaCommand command) {
		var solicitante = solicitanteRepository.findByDni(command.getDni())
				.orElseThrow(()->new ApplicationDomainException("No existe el solicitante con dni: "+command.getDni()));
		solicitante.setCorreo(command.getActualizarLicenciaDto().getCorreo());
		solicitante.setDireccion(command.getActualizarLicenciaDto().getDireccion());
		return solicitante;

	}
	
	private void enviarEvento(Solicitante solicitante) {
		auditService.sendAuditEvent(solicitante, ActionsEnum.UPDATE.getAction());
		
	}

}
