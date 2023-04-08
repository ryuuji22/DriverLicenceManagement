package com.mitocode.licensewriteservice.infraestructure.persistance.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.mitocode.licensewriteservice.domain.entities.TipoCategoria;
import com.mitocode.licensewriteservice.infraestructure.models.TipoCategoriaModel;

@Mapper(componentModel = "spring")
public interface ITipoCategoriaMapper {
	
	TipoCategoria toTipoCategoria(TipoCategoriaModel tipoCategoriaModel);

    List<TipoCategoria> toTipoCategorias(List<TipoCategoriaModel> tipoCategorias);

    @InheritInverseConfiguration
    TipoCategoriaModel toTipoCategoriaModel(TipoCategoria tipoCategoria);

}
