package com.testing.springcloud.persona.error.procesar;

import com.testing.springcloud.common.respuesta.ErrorValidacion;
import com.testing.springcloud.common.respuesta.ErrorValidacionRespuesta;
import com.testing.springcloud.persona.error.ProcesarError;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;

public class procesarErrorValidacion implements ProcesarError {
	@Override
	public Object procesar(Exception excepcion) {
		MethodArgumentNotValidException ex = ((MethodArgumentNotValidException) excepcion);
		List<ErrorValidacion> errores = ex
				.getBindingResult()
				.getAllErrors()
				.stream()
				.map(this::procesarErrorValidacion)
				.collect(Collectors.toList());

		return new ErrorValidacionRespuesta("fallo", errores);
	}

	private ErrorValidacion procesarErrorValidacion(ObjectError objectError) {
		ErrorValidacion error = new ErrorValidacion();
		error.setMensaje(objectError.getDefaultMessage());
		if (objectError instanceof FieldError) {
			error.setCampo(((FieldError) objectError).getField());
		}
		return error;
	}
}
