package com.mitocode.licensewriteservice.application.dtos.requests;

import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearLicenciaDto {

	@NotBlank(message = "DNI field can't be empty.")
	private String dni;

	@NotBlank(message = "Nombres field can't be empty.")
	private String nombres;

	@Email(message = "Please provide a valid email address")
	@Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address")
	private String correo;

	@NotBlank(message = "Direccion field can't be empty.")
	private String direccion;

	@NotBlank(message = "Telefono field can't be empty.")
	private String telefono;

	@NotNull(message = "Edad field can't be empty.")
	@Min(value = 18,message = "Edad must be at least 18")
	private Integer edad;

	@Size(min = 1, message = "There must be at least 1 Category")
	private Set<String> categorias;

}
