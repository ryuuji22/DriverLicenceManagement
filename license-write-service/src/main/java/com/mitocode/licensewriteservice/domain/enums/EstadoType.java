package com.mitocode.licensewriteservice.domain.enums;

public enum EstadoType {
	APROBADO("APROBADO"),
	RENOVADO("RENOVADO");

	String estado;

	EstadoType(String estado) {
		this.estado = estado;
	}
	
	
}
