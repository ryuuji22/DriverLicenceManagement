package com.mitocode.licensewriteservice.infraestructure.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SOLICITANTES", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class SolicitanteModel extends BaseEntityModel{
	
	@Column(nullable = false)
	private String dni;

	@Column(nullable = false)
	private String nombres;

	private String correo;

	private String direccion;

	@Column(nullable = false)
	private String telefono;

	private Integer edad;

}
