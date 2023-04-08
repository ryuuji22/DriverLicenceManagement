package com.mitocode.licensereadservice.domain.interfaces.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.mitocode.licensereadservice.domain.entities.LicenciaReport;

public interface ILicenciaReportRepository {

	String create(LicenciaReport licencia);

	void delete(LicenciaReport licencia);

	void deleteAll();

	Optional<LicenciaReport> findLicenciaReportByDni(String dni);

	Optional<List<LicenciaReport>> findByCategoriasAndFechaVigencia(String[] categorias, LocalDate fechaDesde,
			LocalDate fechaHasta);
}
