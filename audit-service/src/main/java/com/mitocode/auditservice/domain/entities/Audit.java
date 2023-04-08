package com.mitocode.auditservice.domain.entities;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Audit {
	

    private String id;

    private String action;

    private String tableName;

    private String recordId;

    private String userId;

    private Date fecha;

    private LocalDateTime createdAt;

}
