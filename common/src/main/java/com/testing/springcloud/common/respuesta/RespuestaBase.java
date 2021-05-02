package com.testing.springcloud.common.respuesta;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class RespuestaBase {
	private boolean exitoso;
	private final int statusCode;
	private String mensaje;

	public RespuestaBase(boolean exitoso, @NotNull HttpStatus status, String mensaje) {
		this.exitoso = exitoso;
		this.statusCode = status.value();
		this.mensaje = mensaje;
	}



}