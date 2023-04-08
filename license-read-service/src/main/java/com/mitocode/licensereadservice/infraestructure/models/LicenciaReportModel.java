package com.mitocode.licensereadservice.infraestructure.models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("licencia")
@Getter
@Setter
@NoArgsConstructor
public class LicenciaReportModel {

	@Id
	private String id;
	private String dni;
	private String nombres;
	private Integer rut;
	private LocalDate fechaSolicitud;
	private LocalDate fechaValidezDesde;
	private LocalDate fechaValidezHasta;
	private String estado;
	private List<String> categorias;

}
