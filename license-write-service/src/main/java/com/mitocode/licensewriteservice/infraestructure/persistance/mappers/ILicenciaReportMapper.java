package com.mitocode.licensewriteservice.infraestructure.persistance.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mitocode.licensewriteservice.application.dtos.messages.LicenciaReport;
import com.mitocode.licensewriteservice.domain.entities.Licencia;
import com.mitocode.licensewriteservice.domain.entities.LicenciaCategoria;

@Mapper(componentModel = "spring")
public interface ILicenciaReportMapper {
	@Mapping(source = "id", target = "id")
	@Mapping(source = "solicitante.dni", target = "dni")
	@Mapping(source = "solicitante.nombres", target = "nombres")
	@Mapping(source = "rut", target = "rut")
	@Mapping(source = "fechaSolicitud", target = "fechaSolicitud")
	@Mapping(source = "fechaValidezDesde", target = "fechaValidezDesde")
	@Mapping(source = "fechaValidezHasta", target = "fechaValidezHasta")
	@Mapping(source = "estado", target = "estado")
	@Mapping(source = "licenciaCategorias", target = "categorias")

	LicenciaReport toLicenciaReport(Licencia licencia);

	default String mapLicenciaCategoriaModelToString(LicenciaCategoria child) {
		return child.getCategoria().getTipo().getCategoria();
	}

}
