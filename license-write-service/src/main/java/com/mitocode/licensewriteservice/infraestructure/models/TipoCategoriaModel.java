package com.mitocode.licensewriteservice.infraestructure.models;

import java.util.Collection;

import com.mitocode.licensewriteservice.domain.enums.CategoriaType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TIPOS_CATEGORIAS", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class TipoCategoriaModel extends BaseEntityModel {
	
	@Column(name = "tipo", nullable = false)
	@Enumerated(EnumType.STRING)
	private CategoriaType tipo;
	
	@OneToMany(mappedBy = "tipoCategoria", fetch = FetchType.LAZY)
	private Collection<LicenciaCategoriaModel> licenciaCategorias;


}
