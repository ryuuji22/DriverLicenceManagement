package com.mitocode.licensewriteservice.domain.interfaces.repositories;

import java.util.Optional;

import com.mitocode.licensewriteservice.domain.entities.Solicitante;

public interface ISolicitanteRepository {
	Optional<Solicitante> findByDni(String dni);

}
