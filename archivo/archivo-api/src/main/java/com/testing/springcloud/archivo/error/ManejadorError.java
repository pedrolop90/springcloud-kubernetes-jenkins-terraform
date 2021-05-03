package com.testing.springcloud.archivo.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Pedro Lopez
 */
@ControllerAdvice
public class ManejadorError {

	@ExceptionHandler({
			Exception.class
	})
	public final ResponseEntity<Object> handlerException(Exception ex) {
		ResponseEntity<Object> resultado;
		TipoError tipoError = TipoError.capturarError(ex);
		Object mensaje = tipoError.getProcesar().procesar(ex);

		resultado = new ResponseEntity<>(mensaje, tipoError.getEstado());
		return resultado;
	}

}
