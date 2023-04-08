package com.mitocode.licensewriteservice.infraestructure.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LICENCIAS_CATEGORIAS", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class LicenciaCategoriaModel extends BaseEntityModel {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "licencia_id", referencedColumnName = "id")
	private LicenciaModel licencia;

	@ManyToOne
	@JoinColumn(name = "tipo_categoria_id", referencedColumnName = "id")
	private TipoCategoriaModel tipoCategoria;

}
