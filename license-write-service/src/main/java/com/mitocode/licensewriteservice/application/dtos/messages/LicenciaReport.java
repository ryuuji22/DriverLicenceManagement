package com.mitocode.licensewriteservice.application.dtos.messages;

import java.time.LocalDate;
import java.util.List;

import com.mitocode.licensewriteservice.domain.enums.EstadoType;

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
	private EstadoType estado;
	private List<String> categorias;

}
