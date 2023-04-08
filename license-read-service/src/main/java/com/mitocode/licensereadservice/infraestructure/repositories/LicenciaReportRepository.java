package com.mitocode.licensereadservice.infraestructure.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mitocode.licensereadservice.domain.entities.LicenciaReport;
import com.mitocode.licensereadservice.domain.interfaces.repositories.ILicenciaReportRepository;
import com.mitocode.licensereadservice.infraestructure.persistance.mappers.ILicenciaReportMapper;
import com.mitocode.licensereadservice.infraestructure.repositories.jpa.IJpaLicenciaReportRepository;

@Repository
public class LicenciaReportRepository implements ILicenciaReportRepository {

	@Autowired
	private IJpaLicenciaReportRepository repository;

	@Autowired
	private ILicenciaReportMapper mapper;

	@Override
	public String create(LicenciaReport licencia) {
		var licenciaModel = mapper.toLicenciaModel(licencia);
		return repository.save(licenciaModel).getId();

	}

	@Override
	public void delete(LicenciaReport licencia) {
		var licenciaModel = mapper.toLicenciaModel(licencia);
		repository.delete(licenciaModel);

	}

	@Override
	public Optional<LicenciaReport> findLicenciaReportByDni(String dni) {
		return repository.findByDni(dni).map(mapper::toLicencia);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();

	}

	@Override
	public Optional<List<LicenciaReport>> findByCategoriasAndFechaVigencia(String[] categorias, LocalDate fechaDesde,
			LocalDate fechaHasta) {
		return repository.findByCategoriasAndFechaValidez(categorias, fechaDesde, fechaHasta).map(mapper::toLicencias);
	}

}
