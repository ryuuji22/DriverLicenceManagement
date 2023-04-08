package com.mitocode.licensewriteservice.application.services.messages.publish;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mitocode.licensewriteservice.application.dtos.messages.Audit;
import com.mitocode.licensewriteservice.domain.enums.ActionsEnum;
import com.mitocode.licensewriteservice.domain.interfaces.producers.IAuditProducer;
import com.mitocode.licensewriteservice.domain.services.reads.ReadUserAuthenticatedService;

import io.jkratz.mediator.core.CommandHandler;
import io.jkratz.mediator.core.Mediator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PublishAuditCreatedHandler implements CommandHandler<PublishAuditCreated> {

	@Autowired
	private IAuditProducer producer;
	@Autowired
	private Mediator mediator;

	@Override
	@SneakyThrows
	public void handle(PublishAuditCreated command) {
		
		log.info("Enviando evento audit");

		var userId = this.mediator.dispatch(new ReadUserAuthenticatedService());
		var audit = Audit.builder().action(command.getAction()).recordId(command.getRecordId())
				.tableName(command.getTableName()).fecha(command.getFecha()).userId(userId).build();
		if (!command.getAction().equals(ActionsEnum.CREATE)) {
			audit.setFecha(new Date());
		}

		producer.sendAuditCreated(audit);
		
		log.info("Evento audit enviado");

	}

}
