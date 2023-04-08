package com.mitocode.licensewriteservice.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mitocode.licensewriteservice.domain.entities.TipoCategoria;
import com.mitocode.licensewriteservice.domain.enums.CategoriaType;
import com.mitocode.licensewriteservice.domain.interfaces.repositories.ITipoCategoriaRepository;
import com.mitocode.licensewriteservice.infraestructure.persistance.mappers.ITipoCategoriaMapper;
import com.mitocode.licensewriteservice.infraestructure.repositories.jpa.IJpaTipoCategoriaRepository;

@Repository
public class TipoCategoriaRepository implements ITipoCategoriaRepository {

	@Autowired
	private IJpaTipoCategoriaRepository repository;

	@Autowired
	private ITipoCategoriaMapper mapper;

	@Override
	public String create(TipoCategoria tipoCategoria) {
		var tipoCategoriaModel = mapper.toTipoCategoriaModel(tipoCategoria);
		return repository.save(tipoCategoriaModel).getId();
	}

	@Override
	public Optional<List<TipoCategoria>> findByTipoIsIn(List<CategoriaType> tipos) {
		return this.repository.findByTipoIsIn(tipos).map(mapper::toTipoCategorias);
	}

}
