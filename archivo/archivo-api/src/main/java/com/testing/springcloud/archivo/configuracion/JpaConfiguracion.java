package com.testing.springcloud.archivo.configuracion;

import com.testing.springcloud.archivo.interceptor.http.UsuarioSesion;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

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
