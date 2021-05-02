package com.testing.springcloud.persona.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.testing.springcloud.common.constante.ConstanteFecha;
import com.testing.springcloud.common.dto.Modelo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PersonaModelo extends Modelo<Long> {

	private String nombre;

	@JsonFormat(pattern = ConstanteFecha.FECHA)
	private LocalDate fechaNacimiento;

}
