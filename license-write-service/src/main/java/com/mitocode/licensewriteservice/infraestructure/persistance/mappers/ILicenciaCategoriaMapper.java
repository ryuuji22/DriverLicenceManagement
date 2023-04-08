package com.mitocode.licensewriteservice.infraestructure.persistance.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mitocode.licensewriteservice.domain.entities.LicenciaCategoria;
import com.mitocode.licensewriteservice.infraestructure.models.LicenciaCategoriaModel;

@Mapper(componentModel = "spring", uses = {ITipoCategoriaMapper.class})
public interface ILicenciaCategoriaMapper {
	
	@Mapping(source = "id", target = "id")
    @Mapping(source = "licencia.id", target = "licenciaId")
    @Mapping(source = "tipoCategoria", target = "categoria")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "enabled", target = "enabled")
	LicenciaCategoria toLicenciaCategoria(LicenciaCategoriaModel licenciaCategoriaModel);

    List<LicenciaCategoria> toLicenciaCategorias(List<LicenciaCategoriaModel> licenciaCategorias);

    @InheritInverseConfiguration
    LicenciaCategoriaModel toLicenciaCategoriaModel(LicenciaCategoria licenciaCategoria);

}
