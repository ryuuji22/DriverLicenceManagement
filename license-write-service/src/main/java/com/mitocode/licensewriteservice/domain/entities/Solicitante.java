package com.mitocode.licensewriteservice.domain.entities;

import java.util.Date;

import com.mitocode.licensewriteservice.application.dtos.messages.IAuditWrapper;
import com.mitocode.licensewriteservice.domain.enums.TablesEnum;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Solicitante implements IAuditWrapper{

	private String id;

	private String dni;

	private String nombres;

	private String correo;

	private String direccion;

	private String telefono;

	private Integer edad;

	private Date createdAt;

	private Boolean enabled;

	@Override
	public String getTableName() {
		return TablesEnum.SOLICITANTES.getTable();
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
