package com.testing.springcloud.persona.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Error {

	private final String nombreExcepcion;
	private final String mensaje;

}
