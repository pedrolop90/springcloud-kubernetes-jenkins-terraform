package com.testing.springcloud.archivo.entidad;

import com.testing.springcloud.common.dto.AuditoriaEntidad;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Pedro Lopez
 */
@Entity
@Table(name = "ARCHIVO")
@Data
@NoArgsConstructor
public class ArchivoEntidad extends AuditoriaEntidad<String> {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@Column
	private String nombre;

	@Column
	private String grupo;

	@Column
	private String data;
}
