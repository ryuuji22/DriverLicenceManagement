package com.mitocode.auditservice.application.queries;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mitocode.auditservice.domain.entities.Audit;
import com.mitocode.auditservice.domain.interfaces.repositories.IAuditRepository;

import io.jkratz.mediator.core.RequestHandler;

@Component
public class FindAllAuditQueryHandler implements RequestHandler<FindAllAuditQuery, List<Audit>> {

	@Autowired
	private IAuditRepository repository;

	@Override
	public List<Audit> handle(FindAllAuditQuery query) {

		return repository.findAll().orElse(new ArrayList<>());
	}

}
