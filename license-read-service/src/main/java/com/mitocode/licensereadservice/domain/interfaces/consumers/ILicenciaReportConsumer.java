package com.mitocode.licensereadservice.domain.interfaces.consumers;

import com.mitocode.licensereadservice.domain.entities.LicenciaReport;

public interface ILicenciaReportConsumer {

	public void getLicenciaCreated(LicenciaReport licencia);

	public void getLicenciaDeleted(String id);

}
