package com.mitocode.auditservice.infraestructure.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mitocode.auditservice.domain.entities.Audit;
import com.mitocode.auditservice.domain.interfaces.repositories.IAuditRepository;
import com.mitocode.auditservice.infraestructure.persistance.mappers.IAuditMapper;
import com.mitocode.auditservice.infraestructure.repositories.jpa.IJpaAuditRepository;

@Repository
public class AuditRepository implements IAuditRepository {

	@Autowired
	private IJpaAuditRepository repository;

	@Autowired
	private IAuditMapper mapper;

	@Override
	public String create(Audit audit) {
		var auditModel = mapper.toAuditModel(audit);
		return repository.save(auditModel).getId();

	}

	@Override
	public Optional<List<Audit>> findAll() {
		return Optional.of(mapper.toAudits(repository.findAll()));
	}

}
