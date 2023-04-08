package com.mitocode.licensereadservice.application.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mitocode.licensereadservice.domain.entities.LicenciaReport;
import com.mitocode.licensereadservice.domain.exceptions.ApplicationDomainException;
import com.mitocode.licensereadservice.domain.interfaces.repositories.ILicenciaReportRepository;

import io.jkratz.mediator.core.RequestHandler;

@Component
public class GetLicenceByDniQueryHandler implements RequestHandler<GetLicenceByDniQuery, LicenciaReport> {

	@Autowired
	private ILicenciaReportRepository repository;

	@Override
	public LicenciaReport handle(GetLicenceByDniQuery query) {

		return repository.findLicenciaReportByDni(query.getDni())
				.orElseThrow(
						()->new ApplicationDomainException("No existe licencia"));
	}

}
