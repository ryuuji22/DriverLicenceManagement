package com.mitocode.licensewriteservice.domain.entities;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LicenciaCategoria {
	
	private String id;
	
	private String licenciaId;
	
	private TipoCategoria categoria;
	
	private Date createdAt;

	private Boolean enabled;

}
