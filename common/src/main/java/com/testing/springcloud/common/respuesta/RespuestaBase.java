package com.testing.springcloud.common.respuesta;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaBase implements Serializable {
	private boolean exitoso;
	private int statusCode;
	private String mensaje;

	public RespuestaBase(String mensaje) {
		this(true, HttpStatus.OK, mensaje);
	}

	public RespuestaBase(boolean exitoso, @NotNull HttpStatus status, String mensaje) {
		this.exitoso = exitoso;
		this.statusCode = status.value();
		this.mensaje = mensaje;
	}

}