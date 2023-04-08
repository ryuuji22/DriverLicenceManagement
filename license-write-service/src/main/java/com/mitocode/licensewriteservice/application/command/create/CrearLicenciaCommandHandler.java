package com.mitocode.licensewriteservice.application.command.create;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.licensewriteservice.application.dtos.responses.DefaultCreateResponseDto;
import com.mitocode.licensewriteservice.application.services.messages.publish.PublishLicenciaCreated;
import com.mitocode.licensewriteservice.domain.entities.Licencia;
import com.mitocode.licensewriteservice.domain.entities.Solicitante;
import com.mitocode.licensewriteservice.domain.entities.TipoCategoria;
import com.mitocode.licensewriteservice.domain.enums.ActionsEnum;
import com.mitocode.licensewriteservice.domain.enums.CategoriaType;
import com.mitocode.licensewriteservice.domain.enums.EstadoType;
import com.mitocode.licensewriteservice.domain.exceptions.ApplicationDomainException;
import com.mitocode.licensewriteservice.domain.interfaces.repositories.ILicenciaRepository;
import com.mitocode.licensewriteservice.domain.interfaces.repositories.ISolicitanteRepository;
import com.mitocode.licensewriteservice.domain.interfaces.repositories.ITipoCategoriaRepository;
import com.mitocode.licensewriteservice.domain.interfaces.services.ISendAuditEventService;
import com.mitocode.licensewriteservice.domain.services.validations.IValidationActionInterface;
import com.mitocode.licensewriteservice.domain.services.validations.ValidarLicenciaExisteBySolcitante;

import io.jkratz.mediator.core.Mediator;
import io.jkratz.mediator.core.RequestHandler;

@Component
public class CrearLicenciaCommandHandler implements RequestHandler<CrearLicenciaCommand, DefaultCreateResponseDto> {

	@Autowired
	private ILicenciaRepository licenciaRepository;

	@Autowired
	private ISolicitanteRepository solicitanteRepository;

	@Autowired
	private ITipoCategoriaRepository tipoCategoriaRepository;

	@Autowired
	private Mediator mediator;
	
	@Autowired
	private ISendAuditEventService auditService;

	@Autowired
	@Qualifier("createValidationAction")
	private IValidationActionInterface action;

	@Override
	@Transactional
	public DefaultCreateResponseDto handle(CrearLicenciaCommand command) {

		var validarLicencia = new ValidarLicenciaExisteBySolcitante(1, command.getCrearLicenciaDto().getDni(), action,
				Boolean.FALSE);
		this.mediator.dispatch(validarLicencia);

		var solicitante = this.getSolicitante(command);

		var categorias = this.getTipoCategorias(command.getCrearLicenciaDto().getCategorias());

		var licenciaNueva = this.generarLicencia();

		var licenciaId = licenciaRepository.create(solicitante, licenciaNueva, categorias);

		var licenciaDB = licenciaRepository.findById(licenciaId);

		if (licenciaDB.isPresent()) {
			this.enviarEventos(licenciaDB.get());
		}

		return new DefaultCreateResponseDto(licenciaId);
	}

	private List<TipoCategoria> getTipoCategorias(Set<String> categorias) {
		var listCategorias = new ArrayList<CategoriaType>();
		categorias.forEach(categoria -> {
			try {
				var aux = CategoriaType.valueOf(categoria.toUpperCase());
				listCategorias.add(aux);
			} catch (IllegalArgumentException ex) {
				throw new ApplicationDomainException("No existe la categoria: " + categoria);
			}
		});

		return tipoCategoriaRepository.findByTipoIsIn(listCategorias)
				.orElseThrow(() -> new ApplicationDomainException("No existen las categorias"));

	}

	private Solicitante getSolicitante(CrearLicenciaCommand command) {
		var solicitante = solicitanteRepository.findByDni(command.getCrearLicenciaDto().getDni())
				.orElse(Solicitante.builder().build());
		solicitante.setCorreo(command.getCrearLicenciaDto().getCorreo());
		solicitante.setDni(command.getCrearLicenciaDto().getDni());
		solicitante.setDireccion(command.getCrearLicenciaDto().getDireccion());
		solicitante.setNombres(command.getCrearLicenciaDto().getNombres());
		solicitante.setEdad(command.getCrearLicenciaDto().getEdad());
		solicitante.setTelefono(command.getCrearLicenciaDto().getTelefono());
		return solicitante;

	}

	private Licencia generarLicencia() {
		Random rnd = new Random();
		Integer rut = 100000 + rnd.nextInt(900000);

		var fechaActual = LocalDate.now();
		var fechaHastaVigencia = fechaActual.plusDays(1461);

		return Licencia.builder().estado(EstadoType.APROBADO).fechaSolicitud(fechaActual).fechaValidezDesde(fechaActual)
				.fechaValidezHasta(fechaHastaVigencia).rut(rut).build();
	}
	
	private void enviarEventos(Licencia licenciaDB) {
		this.mediator.dispatchAsync(new PublishLicenciaCreated(licenciaDB));
		auditService.sendAuditEvent(licenciaDB, ActionsEnum.CREATE.getAction());
	
	}

}
