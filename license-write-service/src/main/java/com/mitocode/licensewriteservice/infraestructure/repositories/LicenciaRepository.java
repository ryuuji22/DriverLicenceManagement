package com.mitocode.licensewriteservice.infraestructure.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mitocode.licensewriteservice.domain.entities.Licencia;
import com.mitocode.licensewriteservice.domain.entities.LicenciaCategoria;
import com.mitocode.licensewriteservice.domain.entities.Solicitante;
import com.mitocode.licensewriteservice.domain.entities.TipoCategoria;
import com.mitocode.licensewriteservice.domain.interfaces.repositories.ILicenciaRepository;
import com.mitocode.licensewriteservice.infraestructure.models.LicenciaCategoriaModel;
import com.mitocode.licensewriteservice.infraestructure.models.SolicitanteModel;
import com.mitocode.licensewriteservice.infraestructure.persistance.mappers.ILicenciaCategoriaMapper;
import com.mitocode.licensewriteservice.infraestructure.persistance.mappers.ILicenciaMapper;
import com.mitocode.licensewriteservice.infraestructure.persistance.mappers.ISolicitanteMapper;
import com.mitocode.licensewriteservice.infraestructure.repositories.jpa.IJpaLicenciaRepository;
import com.mitocode.licensewriteservice.infraestructure.repositories.jpa.IJpaSolicitanteRepository;

@Repository
public class LicenciaRepository implements ILicenciaRepository {

	@Autowired
	private IJpaLicenciaRepository licenciaRepository;

	@Autowired
	private IJpaSolicitanteRepository solicitanteRepository;

	@Autowired
	private ILicenciaMapper licenciaMapper;

	@Autowired
	private ILicenciaCategoriaMapper licenciaCategoriaMapper;

	@Autowired
	private ISolicitanteMapper solicitanteMapper;

	@Override
	public String create(Solicitante solicitante, Licencia licencia, List<TipoCategoria> categorias) {

		var solicitanteDB = this.saveSolicitante(solicitante);

		var licenciaModel = licenciaMapper.toLicenciaModel(licencia);
		licenciaModel.setSolicitante(solicitanteDB);
		var licenciaCategorias=new ArrayList<LicenciaCategoriaModel>();
		
		categorias.forEach(item -> {
			var licenciaCategoria=new LicenciaCategoria();
			licenciaCategoria.setCategoria(item);
			var licenciaCategoriaModel = licenciaCategoriaMapper.toLicenciaCategoriaModel(licenciaCategoria);
			licenciaCategoriaModel.setLicencia(licenciaModel);
			licenciaCategorias.add(licenciaCategoriaModel);
		});
		
		licenciaModel.setLicenciaCategorias(licenciaCategorias);

		var licenciaDB = licenciaRepository.save(licenciaModel);

		

		return licenciaDB.getId();
	}

	@Override
	public void update(Solicitante solicitante) {
		this.saveSolicitante(solicitante);
	}

	@Override
	public Optional<Licencia> findById(String id) {
		var licencia=this.licenciaRepository.findByIdAndEnabled(id, Boolean.TRUE);
		return licencia.map(licenciaMapper::toLicencia);
	}

	@Override
	public Optional<Licencia> findBySolicitanteDniAndEstado(String dni, String estado) {
		return this.licenciaRepository.findBySolicitanteDniAndEstadoAndEnabled(dni, estado, Boolean.TRUE)
				.map(licenciaMapper::toLicencia);
	}

	@Override
	public Optional<Licencia> findBySolicitanteDni(String dni) {
		return this.licenciaRepository.findBySolicitanteDniAndEnabled(dni, Boolean.TRUE).map(licenciaMapper::toLicencia);
	}
	
	@Override
	public void delete(Licencia licencia) {
		licencia.setEnabled(Boolean.FALSE);
		this.licenciaRepository.save(licenciaMapper.toLicenciaModel(licencia));
		
	}
	
	private SolicitanteModel saveSolicitante(Solicitante solicitante) {
		var solicitanteModel = solicitanteMapper.toSolicitanteModel(solicitante);
		return solicitanteRepository.save(solicitanteModel);

	}


}
