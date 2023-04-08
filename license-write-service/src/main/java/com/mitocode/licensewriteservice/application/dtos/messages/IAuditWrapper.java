package com.mitocode.licensewriteservice.application.dtos.messages;

import java.util.Date;

public interface IAuditWrapper {	
	
	 String getTableName();
	 
	 Date getDate();
	 
	 String getRecordId();

}
