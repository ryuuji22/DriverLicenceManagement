package com.mitocode.licensereadservice.infraestructure.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mitocode.licensereadservice.domain.entities.LicenciaReport;
import com.mitocode.licensereadservice.domain.interfaces.consumers.ILicenciaReportConsumer;
import com.mitocode.licensereadservice.domain.interfaces.repositories.ILicenciaReportRepository;

@Service
public class LicenciaReportConsumer implements ILicenciaReportConsumer {
	
	@Autowired
	private ILicenciaReportRepository repository;

	@Override
	@KafkaListener(topics = { "${app.kafka.consumer.licencia-created-topic}" }, groupId = "default" ,containerFactory = "kafkaListenerContainerFactory" )
	public void getLicenciaCreated(LicenciaReport licencia) {
		repository.create(licencia);
		
	}

	@Override
	@KafkaListener(topics = { "${app.kafka.consumer.licencia-deleted-topic}" }, groupId = "default" ,containerFactory = "kafkaListenerContainerFactory" )
	public void getLicenciaDeleted(String id) {
		var licencia=new LicenciaReport();
		licencia.setId(id);
		repository.delete(licencia);
		
	}


}
