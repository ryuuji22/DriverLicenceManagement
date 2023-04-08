package com.mitocode.licensewriteservice.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mitocode.licensewriteservice.application.dtos.messages.IAuditWrapper;
import com.mitocode.licensewriteservice.application.services.messages.publish.PublishAuditCreated;
import com.mitocode.licensewriteservice.domain.interfaces.services.ISendAuditEventService;

import io.jkratz.mediator.core.Mediator;

@Component
public class SendAuditEventService implements ISendAuditEventService {
	
	@Autowired
	private Mediator mediator;

	@Override
	public void sendAuditEvent(IAuditWrapper audit, String action) {
		var auditCommand=PublishAuditCreated.builder()
				.action(action)
				.fecha(audit.getDate())
				.recordId(audit.getRecordId())
				.tableName(audit.getTableName())
				.build();
		
		this.mediator.dispatchAsync(auditCommand);
		
	}

}
