package com.mitocode.licensewriteservice.domain.interfaces.services;

import com.mitocode.licensewriteservice.application.dtos.messages.IAuditWrapper;

public interface ISendAuditEventService {
	
	void sendAuditEvent(IAuditWrapper audit, String action);

}
