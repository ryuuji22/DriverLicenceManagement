package com.mitocode.licensewriteservice.application.services.messages.publish;

import io.jkratz.mediator.core.Command;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PublishLicenciaDeleted implements Command {
	
	private String id;

}
