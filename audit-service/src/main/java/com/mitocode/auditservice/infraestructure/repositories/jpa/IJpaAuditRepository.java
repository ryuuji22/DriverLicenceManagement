package com.mitocode.auditservice.infraestructure.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.auditservice.infraestructure.models.AuditModel;

public interface IJpaAuditRepository extends JpaRepository<AuditModel, String> {


}
