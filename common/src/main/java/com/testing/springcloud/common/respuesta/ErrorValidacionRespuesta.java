package com.testing.springcloud.common.respuesta;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.testing.springcloud.common.constante.ConstanteFecha;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ErrorValidacionRespuesta extends RespuestaBase {
	@JsonFormat(
			shape = JsonFormat.Shape.STRING,
			pattern = ConstanteFecha.FECHA_HORA
	)
	private LocalDateTime fechaCreacion;
	private List<ErrorValidacion> errores;

	public ErrorValidacionRespuesta(String mensaje, ErrorValidacion... errores) {
		this(mensaje, Arrays.asList(errores));
	}

	public ErrorValidacionRespuesta(String mensaje, List<ErrorValidacion> errores) {
		super(false, HttpStatus.BAD_REQUEST, mensaje);
		this.errores = errores;
		this.fechaCreacion = LocalDateTime.now();
	}
}