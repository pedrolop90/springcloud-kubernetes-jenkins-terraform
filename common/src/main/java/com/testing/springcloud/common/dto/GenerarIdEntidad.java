package com.testing.springcloud.common.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Pedro Lopez
 */
@Data
public class GenerarIdEntidad<ID> implements IdEntidad<ID> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;

}
