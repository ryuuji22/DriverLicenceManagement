package com.mitocode.licensewriteservice.infraestructure.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mitocode.licensewriteservice.domain.entities.Solicitante;
import com.mitocode.licensewriteservice.domain.interfaces.repositories.ISolicitanteRepository;
import com.mitocode.licensewriteservice.infraestructure.persistance.mappers.ISolicitanteMapper;
import com.mitocode.licensewriteservice.infraestructure.repositories.jpa.IJpaSolicitanteRepository;

@Repository
public class SolicitanteRepository implements ISolicitanteRepository {

	@Autowired
	private IJpaSolicitanteRepository repository;

	@Autowired
	private ISolicitanteMapper mapper;


	@Override
	public Optional<Solicitante> findByDni(String dni) {
		return this.repository.findByDniAndEnabled(dni,Boolean.TRUE).map(mapper::toSolicitante);
	}

}
