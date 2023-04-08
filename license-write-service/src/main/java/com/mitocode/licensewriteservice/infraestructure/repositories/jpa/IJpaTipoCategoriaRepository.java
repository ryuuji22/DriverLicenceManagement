package com.mitocode.licensewriteservice.infraestructure.repositories.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.licensewriteservice.domain.enums.CategoriaType;
import com.mitocode.licensewriteservice.infraestructure.models.TipoCategoriaModel;

public interface IJpaTipoCategoriaRepository extends JpaRepository<TipoCategoriaModel, String> {

	public Optional<List<TipoCategoriaModel>> findByTipoIsIn(List<CategoriaType> tipos);

}
