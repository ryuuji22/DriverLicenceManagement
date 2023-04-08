package com.mitocode.auditservice.application.queries;

import java.util.List;

import com.mitocode.auditservice.domain.entities.Audit;

import io.jkratz.mediator.core.Request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindAllAuditQuery implements Request<List<Audit>> {


}
