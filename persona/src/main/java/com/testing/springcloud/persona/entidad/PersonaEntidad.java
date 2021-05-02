package com.testing.springcloud.persona.entidad;

import com.testing.springcloud.common.dto.IdEntidad;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "PERSONA")
@Data
public class PersonaEntidad extends IdEntidad<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nombre;

	@Column
	private LocalDate fechaNacimiento;

}
