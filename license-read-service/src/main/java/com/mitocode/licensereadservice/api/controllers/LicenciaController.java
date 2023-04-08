package com.mitocode.licensereadservice.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.licensereadservice.application.queries.GetLicenceByDniQuery;
import com.mitocode.licensereadservice.application.queries.GetLicenceByFiltersQuery;
import com.mitocode.licensereadservice.domain.entities.LicenciaReport;

import io.jkratz.mediator.core.Mediator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/licencia")
@Slf4j
public class LicenciaController {

	@Autowired
	private Mediator mediator;

	private static final String COMMAND_MESSAGE = "------ Sending query: {} ";

	@Operation(summary = "Consultar Licencia por DNI")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = LicenciaReport.class)) }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
			@ApiResponse(responseCode = "404", description = "Licencia no encontrada", content = @Content) })
	@GetMapping("/{dni}")
	public ResponseEntity<LicenciaReport> getLicense(@PathVariable("dni") String dni) {

		var query = new GetLicenceByDniQuery();
		query.setDni(dni);

		log.info(COMMAND_MESSAGE, query.getClass().getName());

		return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);

	}
	
	@Operation(summary = "Consultar Licencia por Categorias y Fecha de Vigencia")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "OK", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = List.class)) }),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
			@ApiResponse(responseCode = "404", description = "Licencias no encontradas", content = @Content) })
	@GetMapping
	public ResponseEntity<List<LicenciaReport>> getLicenseWithFilters(
			@RequestParam(name = "categorias",required = true) String[] categorias,
			@RequestParam(name = "fechaDesde",required = true) 
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDesde,
			@RequestParam(name = "fechaHsta",required = true) 
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate fechaHasta) {

		var query = new GetLicenceByFiltersQuery();
		query.setCategorias(categorias);
		query.setFechaDesde(fechaDesde);
		query.setFechaHasta(fechaHasta);

		log.info(COMMAND_MESSAGE, query.getClass().getName());

		return new ResponseEntity<>(this.mediator.dispatch(query), HttpStatus.OK);

	}

}
