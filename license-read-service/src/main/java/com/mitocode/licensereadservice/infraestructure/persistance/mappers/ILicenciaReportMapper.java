package com.mitocode.licensereadservice.infraestructure.persistance.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import com.mitocode.licensereadservice.domain.entities.LicenciaReport;
import com.mitocode.licensereadservice.infraestructure.models.LicenciaReportModel;


@Mapper(componentModel = "spring")
public interface ILicenciaReportMapper {
	
	LicenciaReport toLicencia(LicenciaReportModel licenciaModel);

    List<LicenciaReport> toLicencias(List<LicenciaReportModel> licencias);

    @InheritInverseConfiguration
    LicenciaReportModel toLicenciaModel(LicenciaReport licencia);

}
