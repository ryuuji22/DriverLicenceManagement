package com.mitocode.licensewriteservice.domain.interfaces.repositories;

import java.util.List;
import java.util.Optional;

import com.mitocode.licensewriteservice.domain.entities.Licencia;
import com.mitocode.licensewriteservice.domain.entities.Solicitante;
import com.mitocode.licensewriteservice.domain.entities.TipoCategoria;

public interface ILicenciaRepository {

	String create(Solicitante solicitante, Licencia licencia, List<TipoCategoria> categorias);

	void update(Solicitante solicitante);
	
	void delete(Licencia licencia);

	Optional<Licencia> findById(String id);

	Optional<Licencia> findBySolicitanteDniAndEstado(String dni, String estado);
	
	Optional<Licencia> findBySolicitanteDni(String dni);

}
