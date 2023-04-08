package com.mitocode.licensewriteservice.infraestructure.persistance.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mitocode.licensewriteservice.domain.entities.Licencia;
import com.mitocode.licensewriteservice.domain.entities.LicenciaCategoria;
import com.mitocode.licensewriteservice.domain.entities.TipoCategoria;
import com.mitocode.licensewriteservice.infraestructure.models.LicenciaCategoriaModel;
import com.mitocode.licensewriteservice.infraestructure.models.LicenciaModel;

@Mapper(componentModel = "spring", uses = {ISolicitanteMapper.class})
public interface ILicenciaMapper {
	
	@Mapping(source = "licenciaCategorias", target = "licenciaCategorias")
	Licencia toLicencia(LicenciaModel licenciaModel);

    List<Licencia> toLicencias(List<LicenciaModel> licencias);

    @InheritInverseConfiguration
    LicenciaModel toLicenciaModel(Licencia licencia);
    
    default LicenciaCategoria mapLicenciaCategoriaModelToLicenciaCategoria(LicenciaCategoriaModel child) {
    	var licenciaCategoria=new LicenciaCategoria();
    	licenciaCategoria.setLicenciaId(child.getId());
    	licenciaCategoria.setEnabled(child.getEnabled());
    	licenciaCategoria.setId(child.getId());
    	licenciaCategoria.setCreatedAt(child.getCreatedAt());
    	
    	var tipoCategoria=new TipoCategoria();
    	tipoCategoria.setTipo(child.getTipoCategoria().getTipo());
    	tipoCategoria.setId(child.getTipoCategoria().getId());
    	tipoCategoria.setCreatedAt(child.getTipoCategoria().getCreatedAt());
    	tipoCategoria.setEnabled(child.getTipoCategoria().getEnabled());
    	
    	licenciaCategoria.setCategoria(tipoCategoria);
    	
        return licenciaCategoria;
    }

}
