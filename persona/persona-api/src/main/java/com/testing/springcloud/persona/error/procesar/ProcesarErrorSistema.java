package com.testing.springcloud.persona.error.procesar;

import com.testing.springcloud.persona.error.ProcesarError;

public class ProcesarErrorSistema implements ProcesarError {
	@Override
	public Object procesar(Exception excepcion) {
		return excepcion.getMessage();
	}
}
