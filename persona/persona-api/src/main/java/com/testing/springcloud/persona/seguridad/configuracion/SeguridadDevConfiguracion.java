package com.testing.springcloud.persona.seguridad.configuracion;

import com.testing.springcloud.persona.seguridad.interceptor.JwtTokenAutorizacion;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author Pedro Lopez
 */
@Configuration
@Profile("dev")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SeguridadDevConfiguracion extends WebSecurityConfigurerAdapter {

	private final JwtPropiedades jwtPropiedades;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.httpBasic().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilterAfter(new JwtTokenAutorizacion(jwtPropiedades), BasicAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers("/actuator/**").permitAll()
				.anyRequest()
				.authenticated();
	}

}
