package com.mitocode.licensewriteservice.application.services.messages.publish;

import com.mitocode.licensewriteservice.domain.entities.Licencia;

import io.jkratz.mediator.core.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PublishLicenciaCreated implements Command {
	
	private Licencia licencia;

}
