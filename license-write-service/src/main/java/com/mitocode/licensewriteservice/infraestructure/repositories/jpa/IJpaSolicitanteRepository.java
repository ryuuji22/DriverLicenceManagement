package com.mitocode.licensewriteservice.infraestructure.repositories.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.licensewriteservice.infraestructure.models.SolicitanteModel;

public interface IJpaSolicitanteRepository extends JpaRepository<SolicitanteModel, String> {
	
	public Optional<SolicitanteModel> findByDniAndEnabled(String identification, Boolean enabled);


}
