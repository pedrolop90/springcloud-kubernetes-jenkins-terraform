package com.testing.springcloud.common.respuesta;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Pedro Lopez
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListaObjetoRespuesta<T> extends RespuestaBase implements Serializable {
	private long cantidad;
	private List<T> datos;

	public ListaObjetoRespuesta(String mensaje) {
		super(false, HttpStatus.INTERNAL_SERVER_ERROR, mensaje);
	}

	public ListaObjetoRespuesta(HttpStatus status, String mensaje) {
		super(false, status.value(), mensaje);
	}

	public ListaObjetoRespuesta(int statusCode, String mensaje) {
		super(false, statusCode, mensaje);
	}

	public ListaObjetoRespuesta(List<T> datos) {
		this("Exitoso", datos);
	}

	public ListaObjetoRespuesta(Stream<T> datos) {
		this("Exitoso", datos);
	}

	public ListaObjetoRespuesta(List<T> datos, long cantidad) {
		this("Exitoso", datos);
		this.cantidad = cantidad;
	}

	public ListaObjetoRespuesta(String mensaje, List<T> datos) {
		super(true, HttpStatus.OK, mensaje);
		this.datos = datos;
		this.cantidad = datos == null ? 0L : (long) datos.size();
	}

	public ListaObjetoRespuesta(String mensaje, Stream<T> datos) {
		super(true, HttpStatus.OK, mensaje);
		this.datos = datos.collect(Collectors.toList());
		this.cantidad = datos == null ? 0L : (long) this.datos.size();
	}
}
