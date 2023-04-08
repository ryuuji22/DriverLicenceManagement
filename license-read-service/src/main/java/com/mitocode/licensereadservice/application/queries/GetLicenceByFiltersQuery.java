package com.mitocode.licensereadservice.application.queries;

import java.time.LocalDate;
import java.util.List;

import com.mitocode.licensereadservice.domain.entities.LicenciaReport;

import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLicenceByFiltersQuery implements Request<List<LicenciaReport>> {

	private String[] categorias;
	private LocalDate fechaDesde;
	private LocalDate fechaHasta;

}
