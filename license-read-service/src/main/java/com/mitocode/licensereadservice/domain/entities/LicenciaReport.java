package com.mitocode.licensereadservice.domain.entities;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LicenciaReport {
	
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
