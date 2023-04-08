package com.mitocode.auditservice.domain.interfaces.consumers;

import com.mitocode.auditservice.domain.entities.Audit;

public interface IAuditConsumer {

	public void getAuditCreated(Audit audit);

}
