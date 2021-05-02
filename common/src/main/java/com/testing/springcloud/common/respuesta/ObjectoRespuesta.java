package com.testing.springcloud.common.respuesta;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ObjectoRespuesta<T> extends RespuestaBase {
	private T dato;

	public ObjectoRespuesta(T dato) {
		this(HttpStatus.OK, dato);
	}

	public ObjectoRespuesta(String mensaje, T dato) {
		super(true, HttpStatus.OK, mensaje);
		this.dato = dato;
	}

	public ObjectoRespuesta(@NotNull HttpStatus status, T dato) {
		super(true, status, status.getReasonPhrase());
		this.dato = dato;
	}

	public ObjectoRespuesta(HttpStatus status, String mensaje, T dato) {
		super(true, status, mensaje);
		this.dato = dato;
	}

}
