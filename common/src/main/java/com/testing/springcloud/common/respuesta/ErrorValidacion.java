package com.testing.springcloud.common.respuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorValidacion {
	private String campo;
	private String mensaje;

	public ErrorValidacion(String mensaje) {
		this(null, mensaje);
	}
}