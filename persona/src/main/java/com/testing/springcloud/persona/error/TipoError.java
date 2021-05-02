package com.testing.springcloud.persona.error;

import com.testing.springcloud.persona.error.procesar.procesarErrorValidacion;
import com.testing.springcloud.persona.error.procesar.ProcesarErrorSistema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Getter
@AllArgsConstructor
public enum TipoError {

	METHOD_ARGUMENT_NOTVALIDATIONEXCEPTION(
			MethodArgumentNotValidException.class.getSimpleName(),
			new procesarErrorValidacion(),
			HttpStatus.BAD_REQUEST
	),
	SISTEMA(
			"",
			new ProcesarErrorSistema(),
			HttpStatus.INTERNAL_SERVER_ERROR
	);

	private String nombreClase;
	private ProcesarError procesar;
	private HttpStatus estado;

	public static TipoError capturarError(Exception excepcion) {
		TipoError tipoError = TipoError.SISTEMA;
		String nombreClase = excepcion.getClass().getSimpleName();
		for (TipoError value : TipoError.values()) {
			if (value.getNombreClase().equalsIgnoreCase(nombreClase)) {
				return value;
			}
		}
		return tipoError;
	}

}
