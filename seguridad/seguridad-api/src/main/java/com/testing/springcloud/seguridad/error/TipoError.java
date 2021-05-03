package com.testing.springcloud.seguridad.error;

import com.testing.springcloud.common.error.ProcesarError;
import com.testing.springcloud.common.error.procesar.ProcesarErrorSistema;
import com.testing.springcloud.common.error.procesar.procesarErrorValidacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * @author Pedro Lopez
 */
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
