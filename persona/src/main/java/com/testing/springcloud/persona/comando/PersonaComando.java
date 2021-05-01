package com.testing.springcloud.persona.comando;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PersonaComando {
	@NotBlank
	private String nombre;

}
