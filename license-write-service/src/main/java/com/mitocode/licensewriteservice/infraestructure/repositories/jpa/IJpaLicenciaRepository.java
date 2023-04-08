package com.mitocode.licensewriteservice.infraestructure.repositories.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.licensewriteservice.infraestructure.models.LicenciaModel;

public interface IJpaLicenciaRepository extends JpaRepository<LicenciaModel, String> {
	
	public Optional<LicenciaModel> findByIdAndEnabled(String id, Boolean enabled);
	
	public Optional<LicenciaModel> findBySolicitanteDniAndEstadoAndEnabled(String dni,String estado, Boolean enabled);
	
	public Optional<LicenciaModel> findBySolicitanteDniAndEnabled(String dni, Boolean enabled);

}
