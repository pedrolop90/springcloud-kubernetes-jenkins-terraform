package com.testing.springcloud.zuul.seguridad.configuracion;

import com.testing.springcloud.zuul.seguridad.autenticacion.AplicacionLoginService;
import com.testing.springcloud.zuul.seguridad.interceptor.JwtLoginFiltro;
import com.testing.springcloud.zuul.seguridad.interceptor.JwtTokenAutorizacion;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Pedro Lopez
 */
@Configuration
@Profile("dev")
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SeguridadDevConfiguracion extends WebSecurityConfigurerAdapter {

	private final AplicacionLoginService aplicacionLoginService;
	private final PasswordEncoder passwordEncoder;
	private final JwtPropiedades jwtPropiedades;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.addFilter(new JwtLoginFiltro(authenticationManager(), jwtPropiedades))
				.addFilterAfter(new JwtTokenAutorizacion(jwtPropiedades), JwtLoginFiltro.class)
				.authorizeRequests()
				.antMatchers("/actuator/**").permitAll()
				.anyRequest()
				.authenticated();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(aplicacionLoginService).passwordEncoder(passwordEncoder);
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		daoAuthenticationProvider.setUserDetailsService(aplicacionLoginService);
		return daoAuthenticationProvider;
	}
}
