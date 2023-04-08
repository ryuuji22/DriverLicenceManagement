package com.mitocode.licensewriteservice.infraestructure.persistance.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.mitocode.licensewriteservice.domain.entities.Solicitante;
import com.mitocode.licensewriteservice.infraestructure.models.SolicitanteModel;

@Mapper(componentModel = "spring")
public interface ISolicitanteMapper {
	
	Solicitante toSolicitante(SolicitanteModel solicitanteModel);

    List<Solicitante> toSolicitantes(List<SolicitanteModel> solicitantes);

    @InheritInverseConfiguration
    SolicitanteModel toSolicitanteModel(Solicitante solicitante);

}
