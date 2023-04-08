package com.mitocode.licensereadservice.application.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mitocode.licensereadservice.domain.entities.LicenciaReport;
import com.mitocode.licensereadservice.domain.exceptions.ApplicationDomainException;
import com.mitocode.licensereadservice.domain.interfaces.repositories.ILicenciaReportRepository;

import io.jkratz.mediator.core.RequestHandler;

@Component
public class GetLicenceByFiltersQueryHandler implements RequestHandler<GetLicenceByFiltersQuery, List<LicenciaReport>> {

	@Autowired
	private ILicenciaReportRepository repository;

	@Override
	public List<LicenciaReport> handle(GetLicenceByFiltersQuery query) {

		return repository
				.findByCategoriasAndFechaVigencia(query.getCategorias(), query.getFechaDesde(), query.getFechaHasta())
				.orElseThrow(() -> new ApplicationDomainException("No existen licencias para los criterios ingresados"));
	}

}
