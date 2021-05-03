package com.testing.springcloud.persona.controlador;

import com.testing.springcloud.common.controlador.ControladorBaseImpl;
import com.testing.springcloud.persona.modelo.PersonaModelo;
import com.testing.springcloud.persona.servicio.PersonaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pedro Lopez
 */
@RestController
@RequestMapping(value = "personas")
@RequiredArgsConstructor
public class PersonaControlador extends ControladorBaseImpl<Long, PersonaModelo> {

	private final PersonaServicio personaServicio;

	@Override
	public PersonaServicio obtenerServicio() {
		return personaServicio;
	}
}
