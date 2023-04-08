package com.mitocode.licensewriteservice.domain.entities;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import com.mitocode.licensewriteservice.application.dtos.messages.IAuditWrapper;
import com.mitocode.licensewriteservice.domain.enums.EstadoType;
import com.mitocode.licensewriteservice.domain.enums.TablesEnum;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Licencia implements IAuditWrapper {

	private String id;

	private Integer rut;

	private LocalDate fechaSolicitud;

	private LocalDate fechaValidezDesde;

	private LocalDate fechaValidezHasta;

	private EstadoType estado;

	private Solicitante solicitante;
	
	private Collection<LicenciaCategoria> licenciaCategorias;

	private Date createdAt;

	private Boolean enabled;

	@Override
	public String getTableName() {
		return TablesEnum.LICENCIAS.getTable();
	}

	@Override
	public Date getDate() {
		return createdAt;
	}

	@Override
	public String getRecordId() {
		return id;
	}


}
