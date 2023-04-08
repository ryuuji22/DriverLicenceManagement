package com.mitocode.licensewriteservice.domain.interfaces.producers;

import com.mitocode.licensewriteservice.application.dtos.messages.Audit;

public interface IAuditProducer {
	
	public void sendAuditCreated(Audit audit);
	

}
