package com.testing.springcloud.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import java.time.LocalDateTime;

/**
 * @author Pedro Lopez
 */
@Data
public abstract class AuditoriaEntidad<ID> implements IdEntidad<ID> {

	@Column(name = "fechaCreacion", nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime fechaCreacion;

	@Column(name = "fechaModificacion")
	@LastModifiedDate
	private LocalDateTime fechaModificacion;

	@Column(name = "creadoPor")
	@CreatedBy
	private String creadoPor;

	@Column(name = "modificadoPor")
	@LastModifiedBy
	private String modificadoPor;

}
