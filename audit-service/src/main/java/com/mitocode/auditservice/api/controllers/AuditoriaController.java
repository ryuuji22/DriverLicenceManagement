package com.mitocode.auditservice.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.auditservice.application.queries.FindAllAuditQuery;
import com.mitocode.auditservice.domain.entities.Audit;

import io.jkratz.mediator.core.Mediator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/auditoria")
@Slf4j
public class AuditoriaController {

	@Autowired
	private Mediator mediator;

	private static final String COMMAND_MESSAGE = "------ Sending query: {} ";

	
	@Operation(summary = "Consultar todos los registros de auditoria")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = List.class)) }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
			@ApiResponse(responseCode = "404", description = "Licencias no encontradas", content = @Content) })
	@GetMapping
	public ResponseEntity<List<Audit>> getAllAudits() {

		var query = new FindAllAuditQuery();

		log.info(COMMAND_MESSAGE, query.getClass().getName());

		return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);

	}

}
