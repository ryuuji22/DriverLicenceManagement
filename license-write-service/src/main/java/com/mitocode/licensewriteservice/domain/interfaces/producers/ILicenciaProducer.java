package com.mitocode.licensewriteservice.domain.interfaces.producers;

import com.mitocode.licensewriteservice.domain.entities.Licencia;

public interface ILicenciaProducer {
	
	public void sendLicenciaCreated(Licencia licencia);
	
	public void sendLicenciaDeleted(String id);

}
