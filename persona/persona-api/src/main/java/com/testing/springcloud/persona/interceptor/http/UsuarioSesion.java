package com.testing.springcloud.persona.interceptor.http;

public class UsuarioSesion {

	private static ThreadLocal<String> USUARIO_SESION = new ThreadLocal<>();

	public static String obtenerUsuarioSesion() {
		return USUARIO_SESION.get();
	}

	public static void asignarUsuarioSesion(String usuarioSesion) {
		USUARIO_SESION.set(usuarioSesion);
	}

}
