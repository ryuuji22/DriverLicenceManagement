package com.mitocode.licensewriteservice.application.services.messages.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mitocode.licensewriteservice.domain.interfaces.producers.ILicenciaProducer;

import io.jkratz.mediator.core.CommandHandler;

@Component
public class PublishLicenciaDeletedHandler implements CommandHandler<PublishLicenciaDeleted> {

	@Autowired
	private ILicenciaProducer producer;

	@Override
	public void handle(PublishLicenciaDeleted command) {
		producer.sendLicenciaDeleted(command.getId());

	}

}
