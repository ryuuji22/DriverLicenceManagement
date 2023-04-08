package com.mitocode.licensewriteservice.application.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualizarLicenciaDto {

	@Email(message = "Please provide a valid email address")
	@Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
	private String correo;

	@NotBlank(message = "Direccion field can't be empty.")
	private String direccion;

	@NotBlank(message = "Telefono field can't be empty.")
	private String telefono;


}
