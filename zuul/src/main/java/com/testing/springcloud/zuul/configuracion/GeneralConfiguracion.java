package com.testing.springcloud.zuul.configuracion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Pedro Lopez
 */
@Configuration
public class GeneralConfiguracion implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedHeaders("*")
				.allowedMethods("POST", "GET", "PUT", "OPTIONS", "POST", "DELETE", "PATH");
	}

}
