package com.testing.springcloud.archivo.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.testing.springcloud.common.dto.Modelo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pedro Lopez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArchivoModelo extends Modelo<String> {

	private String nombre;
	private String grupo;
	private String data;

}
