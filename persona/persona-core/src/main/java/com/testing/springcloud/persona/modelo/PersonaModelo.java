package com.testing.springcloud.persona.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.testing.springcloud.common.constante.ConstanteFecha;
import com.testing.springcloud.common.dto.Modelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonaModelo extends Modelo<Long> implements Serializable {

	private String nombre;

	@JsonFormat(pattern = ConstanteFecha.FECHA)
	private LocalDate fechaNacimiento;

}
