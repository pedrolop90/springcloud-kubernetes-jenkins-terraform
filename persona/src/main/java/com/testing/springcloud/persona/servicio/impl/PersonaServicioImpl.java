package com.testing.springcloud.persona.servicio.impl;

import com.testing.springcloud.common.servicio.impl.ServicioBaseImpl;
import com.testing.springcloud.persona.convertidor.PersonaModeloToPersonaEntidadConvertidor;
import com.testing.springcloud.persona.entidad.PersonaEntidad;
import com.testing.springcloud.persona.modelo.PersonaModelo;
import com.testing.springcloud.persona.repositorio.PersonaRepositorio;
import com.testing.springcloud.persona.servicio.PersonaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonaServicioImpl extends ServicioBaseImpl<Long, PersonaModelo, PersonaEntidad>
		implements PersonaServicio {

	private final PersonaRepositorio personaRepositorio;
	private final PersonaModeloToPersonaEntidadConvertidor personaModeloToPersonaEntidadConvertidor;

	@Override
	protected PersonaRepositorio obtenerRepositorio() {
		return personaRepositorio;
	}

	@Override
	protected PersonaModeloToPersonaEntidadConvertidor obtenerConversionBase() {
		return personaModeloToPersonaEntidadConvertidor;
	}
}
