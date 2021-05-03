package com.testing.springcloud.zuul.seguridad.configuracion;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Pedro Lopez
 */
@Configuration
@Profile("disabled")
@EnableWebSecurity
@RequiredArgsConstructor
public class SeguridadDeshabilitarConfiguracion extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.httpBasic().disable()
				.authorizeRequests().mvcMatchers("/*").permitAll();
	}

}
