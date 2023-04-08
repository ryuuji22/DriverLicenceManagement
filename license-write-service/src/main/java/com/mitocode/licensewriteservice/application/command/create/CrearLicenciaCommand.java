package com.mitocode.licensewriteservice.application.command.create;

import com.mitocode.licensewriteservice.application.dtos.requests.CrearLicenciaDto;
import com.mitocode.licensewriteservice.application.dtos.responses.DefaultCreateResponseDto;

import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearLicenciaCommand implements Request<DefaultCreateResponseDto> {
	
	private CrearLicenciaDto crearLicenciaDto;

}
