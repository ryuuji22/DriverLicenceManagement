package com.mitocode.licensewriteservice.infraestructure.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.licensewriteservice.infraestructure.models.LicenciaCategoriaModel;

public interface IJpaLicenciaCategoriaRepository extends JpaRepository<LicenciaCategoriaModel, String> {

}
