package com.testing.springcloud.archivo.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author pedro
 */
@Configuration
public class SwaggerConfiguracion {

	private static final String RUTA_PRINCIPAL = "com.testing.springcloud.archivo";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage(RUTA_PRINCIPAL))
				.paths(PathSelectors.any())
				.build();
	}

}
