package com.testing.springcloud.archivo.servicio.impl;

import com.testing.springcloud.archivo.convertidor.ArchivoModeloToArchivoEntidadConvertidor;
import com.testing.springcloud.archivo.entidad.ArchivoEntidad;
import com.testing.springcloud.archivo.modelo.ArchivoModelo;
import com.testing.springcloud.archivo.repositorio.ArchivoRepositorio;
import com.testing.springcloud.archivo.servicio.ArchivoServicio;
import com.testing.springcloud.common.servicio.impl.ServicioBaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArchivoServicioImpl extends ServicioBaseImpl<String, ArchivoModelo, ArchivoEntidad>
		implements ArchivoServicio {

	private final ArchivoRepositorio archivoRepositorio;
	private final ArchivoModeloToArchivoEntidadConvertidor archivoModeloToArchivoEntidadConvertidor;

	@Override
	protected ArchivoRepositorio obtenerRepositorio() {
		return archivoRepositorio;
	}

	@Override
	protected ArchivoModeloToArchivoEntidadConvertidor obtenerConversionBase() {
		return archivoModeloToArchivoEntidadConvertidor;
	}
}
