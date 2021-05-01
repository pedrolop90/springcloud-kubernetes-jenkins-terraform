package com.testing.springcloud.persona.error;

@FunctionalInterface
public interface ProcesarError {

	Object procesar(Exception e);

}
