package com.mitocode.auditservice.infraestructure.persistance.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.mitocode.auditservice.domain.entities.Audit;
import com.mitocode.auditservice.infraestructure.models.AuditModel;


@Mapper(componentModel = "spring")
public interface IAuditMapper {
	
	Audit toAudit(AuditModel auditModel);

    List<Audit> toAudits(List<AuditModel> audits);

    @InheritInverseConfiguration
    AuditModel toAuditModel(Audit audit);

}
