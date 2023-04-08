package com.mitocode.licensereadservice.application.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DniQueryRequestDto {
	@NotBlank(message = "DNI field can't be empty.")
	private String dni;

}
