package com.mitocode.licensereadservice.infraestructure.repositories.jpa;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.mitocode.licensereadservice.infraestructure.models.LicenciaReportModel;

public interface IJpaLicenciaReportRepository extends MongoRepository<LicenciaReportModel, String> {

	Optional<LicenciaReportModel> findByDni(String dni);

	@Query(value = "{ 'categorias' : {$in : ?0 }, 'fechaValidezHasta' : { $gte: ?1, $lte: ?2 } }")
	Optional<List<LicenciaReportModel>> findByCategoriasAndFechaValidez(String[] categorias, LocalDate fechaDesde,
			LocalDate fechaHasta);

}
