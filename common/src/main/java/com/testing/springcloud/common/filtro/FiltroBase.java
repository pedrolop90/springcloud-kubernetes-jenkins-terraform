package com.testing.springcloud.common.filtro;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pedro Lopez
 */
@Data
@NoArgsConstructor
public class FiltroBase {

	private Integer numeroPagina;
	private Integer totalElementos;

}
