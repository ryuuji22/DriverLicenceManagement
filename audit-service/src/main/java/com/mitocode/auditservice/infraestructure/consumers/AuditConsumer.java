package com.mitocode.auditservice.infraestructure.consumers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.mitocode.auditservice.domain.entities.Audit;
import com.mitocode.auditservice.domain.interfaces.consumers.IAuditConsumer;
import com.mitocode.auditservice.domain.interfaces.repositories.IAuditRepository;

@Service
public class AuditConsumer implements IAuditConsumer {
	
	@Autowired
	private IAuditRepository repository;

	@Override
	@KafkaListener(topics = { "${app.kafka.consumer.audit-created-topic}" }, groupId = "default" ,containerFactory = "kafkaListenerContainerFactory" )
	public void getAuditCreated(Audit licencia) {
		repository.create(licencia);
		
	}


}
