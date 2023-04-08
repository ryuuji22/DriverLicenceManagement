package com.mitocode.licensewriteservice.domain.services.validations;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mitocode.licensewriteservice.domain.entities.Licencia;
import com.mitocode.licensewriteservice.domain.exceptions.ApplicationDomainException;
import com.mitocode.licensewriteservice.domain.interfaces.repositories.ILicenciaRepository;

import io.jkratz.mediator.core.CommandHandler;

@Component
public class ValidarLicenciaExisteBySolcitanteHandler implements CommandHandler<ValidarLicenciaExisteBySolcitante> {

	@Autowired
	private ILicenciaRepository licenciaRepository;

	@Override
	public void handle(ValidarLicenciaExisteBySolcitante query) {
		var licencia = licenciaRepository.findBySolicitanteDni(query.getDni());

		if (!licencia.isEmpty()) {
			var licenciaDb = licencia.get();
			this.ejecutarRestriccion(licenciaDb, query);

		}else if (Boolean.TRUE.equals(query.getPostException())) {
			throw new ApplicationDomainException("No existe una licencia para el dni: " + query.getDni());
		}

	}

	private void ejecutarRestriccion(Licencia licenciaDb, ValidarLicenciaExisteBySolcitante query) {
		if (LocalDate.now().isBefore(licenciaDb.getFechaValidezHasta())) {
			throw new ApplicationDomainException("Tiene una licencia vigente");
		}
		long p2 = ChronoUnit.DAYS.between(licenciaDb.getFechaValidezHasta(), LocalDate.now());
		if (p2 >= query.getDiasVigencia()) {
			query.getAction().doAction(licenciaDb);
		}

	}

}
