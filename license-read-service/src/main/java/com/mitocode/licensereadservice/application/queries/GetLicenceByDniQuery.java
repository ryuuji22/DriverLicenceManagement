package com.mitocode.licensereadservice.application.queries;

import com.mitocode.licensereadservice.domain.entities.LicenciaReport;

import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetLicenceByDniQuery implements Request<LicenciaReport> {

	private String dni;

}
