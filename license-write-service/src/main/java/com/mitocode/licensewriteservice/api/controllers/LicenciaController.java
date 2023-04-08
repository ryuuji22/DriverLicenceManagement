package com.mitocode.licensewriteservice.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.licensewriteservice.application.command.create.CrearLicenciaCommand;
import com.mitocode.licensewriteservice.application.command.delete.EliminarLicenciaCommand;
import com.mitocode.licensewriteservice.application.command.update.ActualizarLicenciaCommand;
import com.mitocode.licensewriteservice.application.dtos.requests.ActualizarLicenciaDto;
import com.mitocode.licensewriteservice.application.dtos.requests.CrearLicenciaDto;
import com.mitocode.licensewriteservice.application.dtos.responses.DefaultCreateResponseDto;

import io.jkratz.mediator.core.Mediator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/licencia")
@Slf4j
public class LicenciaController {

	@Autowired
	private Mediator mediator;

	private static final String COMMAND_MESSAGE = "------ Sending command: {} ";

	@PostMapping
	@Operation(summary = "Crear una licencia con los datos del solicitante")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = DefaultCreateResponseDto.class)) }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
			@ApiResponse(responseCode = "404", description = "Not Found", content = @Content) })
	public ResponseEntity<DefaultCreateResponseDto> createLicense(@Valid @RequestBody CrearLicenciaDto dto) {

		var command = new CrearLicenciaCommand();
		command.setCrearLicenciaDto(dto);
		log.info(COMMAND_MESSAGE, command.getClass().getName());

		return new ResponseEntity<>(this.mediator.dispatch(command), HttpStatus.CREATED);

	}

	@Operation(summary = "Actualizar los datos del solicitante de la licencia")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = @Content),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
			@ApiResponse(responseCode = "404", description = "Solicitante no encontrado", content = @Content) })
	@PutMapping("/{dni}")
	public ResponseEntity<Void> updateLicense(@PathVariable("dni") String dni,
			@Valid @RequestBody ActualizarLicenciaDto dto) {

		var command = new ActualizarLicenciaCommand();
		command.setActualizarLicenciaDto(dto);
		command.setDni(dni);

		log.info(COMMAND_MESSAGE, command.getClass().getName());

		this.mediator.dispatch(command);

		return ResponseEntity.status(HttpStatus.OK).build();

	}

	@Operation(summary = "Eliminar licencia no vigente")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = @Content),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
			@ApiResponse(responseCode = "404", description = "Licencia no encontrada", content = @Content) })
	@DeleteMapping("/{dni}")
	public ResponseEntity<Void> deleteLicense(@PathVariable("dni") String dni) {

		var command = new EliminarLicenciaCommand();
		command.setDni(dni);

		log.info(COMMAND_MESSAGE, command.getClass().getName());

		this.mediator.dispatch(command);

		return ResponseEntity.status(HttpStatus.OK).build();

	}

	@PostMapping("/ping")
	public String ping() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		return "Scopes: " + authentication.getName();
	}

}
