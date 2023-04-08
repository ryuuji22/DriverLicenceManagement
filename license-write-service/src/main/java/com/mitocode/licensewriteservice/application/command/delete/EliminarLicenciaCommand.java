package com.mitocode.licensewriteservice.application.command.delete;

import io.jkratz.mediator.core.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EliminarLicenciaCommand implements Command {
	private String dni;

}
