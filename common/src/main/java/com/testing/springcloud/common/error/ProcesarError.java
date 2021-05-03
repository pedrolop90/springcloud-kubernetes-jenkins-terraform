package com.testing.springcloud.common.error;

/**
 * @author Pedro Lopez
 */
@FunctionalInterface
public interface ProcesarError {

	Object procesar(Exception excepcion);

}
