package com.mitocode.licensewriteservice.application.services.messages.publish;

import java.util.Date;

import io.jkratz.mediator.core.Command;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PublishAuditCreated implements Command {
	
	private String auditId;
    private String action;
    private String tableName;
    private String recordId;
    private Date fecha;

}
