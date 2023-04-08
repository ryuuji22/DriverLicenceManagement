package com.mitocode.licensewriteservice.infraestructure.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.mitocode.licensewriteservice.domain.entities.Licencia;
import com.mitocode.licensewriteservice.domain.interfaces.producers.ILicenciaProducer;
import com.mitocode.licensewriteservice.infraestructure.persistance.mappers.ILicenciaReportMapper;

@Component
public class LicenciaProducer implements ILicenciaProducer {

	@Autowired
	private KafkaTemplate<String, Object> template;
	@Autowired
	private ILicenciaReportMapper reportMapper;
	@Value("${app.kafka.producer.licencia-created-topic}")
    private  String licenciaCreatedTopic;
	@Value("${app.kafka.producer.licencia-deleted-topic}")
    private  String licenciaDeletedTopic;



	@Override
	public void sendLicenciaCreated(Licencia licencia) {
		var licenciaReport=reportMapper.toLicenciaReport(licencia);
		this.template.send(licenciaCreatedTopic, licenciaReport);

	}

	@Override
	public void sendLicenciaDeleted(String id) {
		this.template.send(licenciaDeletedTopic, id);

	}

}
