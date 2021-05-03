package com.testing.springcloud.common.error.procesar;


import com.testing.springcloud.common.error.ProcesarError;

/**
 * @author Pedro Lopez
 */
public class ProcesarErrorSistema implements ProcesarError {
	@Override
	public Object procesar(Exception excepcion) {
		return excepcion.getMessage();
	}
}
