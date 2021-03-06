package com.testing.springcloud.common.respuesta;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Pedro Lopez
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjetoRespuesta<T> extends RespuestaBase implements Serializable {
	private T dato;

	public ObjetoRespuesta(T dato) {
		this(HttpStatus.OK, dato);
	}

	public ObjetoRespuesta(String mensaje, T dato) {
		super(true, HttpStatus.OK, mensaje);
		this.dato = dato;
	}

	public ObjetoRespuesta(@NotNull HttpStatus status, T dato) {
		super(true, status, status.getReasonPhrase());
		this.dato = dato;
	}

	public ObjetoRespuesta(HttpStatus status, String mensaje, T dato) {
		super(true, status, mensaje);
		this.dato = dato;
	}

}
