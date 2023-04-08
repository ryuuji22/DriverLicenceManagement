package com.mitocode.licensewriteservice.infraestructure.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.mitocode.licensewriteservice.application.dtos.messages.Audit;
import com.mitocode.licensewriteservice.domain.interfaces.producers.IAuditProducer;

@Component
public class AuditProducer implements IAuditProducer {

	@Autowired
	private KafkaTemplate<String, Object> template;
	@Value("${app.kafka.producer.audit-created-topic}")
    private  String auditCreatedTopic;

	@Override
	public void sendAuditCreated(Audit audit) {
		this.template.send(auditCreatedTopic, audit);

	}

	

}
