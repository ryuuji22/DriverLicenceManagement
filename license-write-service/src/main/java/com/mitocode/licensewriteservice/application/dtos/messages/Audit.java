package com.mitocode.licensewriteservice.application.dtos.messages;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Audit {
	
	private String auditId;
    private String action;
    private String tableName;
    private String recordId;
    private String userId;
    private Date fecha;

}
