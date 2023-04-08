package com.mitocode.licensewriteservice.domain.entities;

import java.util.Date;

import com.mitocode.licensewriteservice.domain.enums.CategoriaType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoCategoria {
	
	private String id;
	
	private CategoriaType tipo;
	
	private Boolean enabled;
	
	private Date createdAt;

}
