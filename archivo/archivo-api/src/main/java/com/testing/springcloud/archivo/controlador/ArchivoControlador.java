package com.testing.springcloud.archivo.controlador;

import com.testing.springcloud.archivo.modelo.ArchivoModelo;
import com.testing.springcloud.archivo.servicio.ArchivoServicio;
import com.testing.springcloud.common.controlador.ControladorBaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("archivos")
@RequiredArgsConstructor
public class ArchivoControlador extends ControladorBaseImpl<String, ArchivoModelo> {

	private final ArchivoServicio archivoServicio;

	@Override
	public ArchivoServicio obtenerServicio() {
		return archivoServicio;
	}
}
