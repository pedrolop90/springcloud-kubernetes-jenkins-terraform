package com.testing.springcloud.seguridad.configuracion;

import com.testing.springcloud.seguridad.interceptor.http.UsuarioSesion;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * @author Pedro Lopez
 */
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaConfiguracion {

	@Bean
	AuditorAware<String> auditorProvider() {
		return new AuditorAware<String>() {
			@Override
			public Optional<String> getCurrentAuditor() {
				return Optional.of(UsuarioSesion.obtenerUsuarioSesion());
			}
		};
	}

}
