package com.testing.springcloud.common.filtro;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FiltroBase {

	private Integer numeroPagina;
	private Integer totalElementos;

}
