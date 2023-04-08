package com.mitocode.licensewriteservice.domain.interfaces.repositories;

import java.util.List;
import java.util.Optional;

import com.mitocode.licensewriteservice.domain.entities.TipoCategoria;
import com.mitocode.licensewriteservice.domain.enums.CategoriaType;

public interface ITipoCategoriaRepository {
	
	String create(TipoCategoria tipoCategoria);

	Optional<List<TipoCategoria>> findByTipoIsIn(List<CategoriaType> tipos);

}
