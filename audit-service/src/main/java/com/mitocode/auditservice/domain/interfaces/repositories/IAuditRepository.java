package com.mitocode.auditservice.domain.interfaces.repositories;

import java.util.List;
import java.util.Optional;

import com.mitocode.auditservice.domain.entities.Audit;

public interface IAuditRepository {

	String create(Audit licencia);

	Optional<List<Audit>> findAll();
}
