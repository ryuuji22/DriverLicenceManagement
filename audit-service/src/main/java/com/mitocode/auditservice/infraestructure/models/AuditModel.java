package com.mitocode.auditservice.infraestructure.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AUDIT")
@Setter
@Getter
public class AuditModel {

    @Id
    private String id;

    private String action;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "record_id")
    private String recordId;

    @Column(name = "user_id")
    private String userId;
    
    @Column(name = "action_date")
    private Date fecha;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
    	createdAt = LocalDateTime.now();
        this.setId(UUID.randomUUID().toString());
    }
}
