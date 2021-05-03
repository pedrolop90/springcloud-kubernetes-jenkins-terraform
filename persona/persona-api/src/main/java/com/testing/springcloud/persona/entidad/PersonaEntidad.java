package com.testing.springcloud.persona.entidad;

import com.testing.springcloud.common.dto.AuditoriaEntidad;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author Pedro Lopez
 */
@Entity
@Table(name = "PERSONA")
@EntityListeners(AuditingEntityListener.class)
@Data
public class PersonaEntidad extends AuditoriaEntidad<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nombre;

	@Column
	private LocalDate fechaNacimiento;

}
