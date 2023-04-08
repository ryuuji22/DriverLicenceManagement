package com.mitocode.licensewriteservice.application.services.messages.publish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mitocode.licensewriteservice.domain.interfaces.producers.ILicenciaProducer;

import io.jkratz.mediator.core.CommandHandler;

@Component
public class PublishLicenciaCreatedHandler implements CommandHandler<PublishLicenciaCreated> {

	@Autowired
	private ILicenciaProducer producer;

	@Override
	public void handle(PublishLicenciaCreated command) {
		producer.sendLicenciaCreated(command.getLicencia());

	}

}
