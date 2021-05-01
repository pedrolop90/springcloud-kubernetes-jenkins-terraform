package com.testing.springcloud.persona.controlador;

import com.testing.springcloud.persona.comando.PersonaComando;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "personas")
@RequiredArgsConstructor
public class PersonaControlador {

	@GetMapping
	public String obtenerSaludo() {
		return "hola....";
	}

	@PostMapping
	public String guardarSaludo(@RequestBody @Valid PersonaComando personaComando) {
		return "sapo....";
	}

}
