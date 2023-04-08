package com.mitocode.licensewriteservice.application.command.update;

import com.mitocode.licensewriteservice.application.dtos.requests.ActualizarLicenciaDto;

import io.jkratz.mediator.core.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualizarLicenciaCommand implements Command {
	
	private String dni;
	private ActualizarLicenciaDto actualizarLicenciaDto;

}
