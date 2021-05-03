package com.testing.springcloud.seguridad.seguridad.dao.impl;

import com.testing.springcloud.seguridad.seguridad.dao.UsuarioDao;
import com.testing.springcloud.seguridad.seguridad.entidad.UsuarioEntidad;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Pedro Lopez
 */
@Repository("fake")
@RequiredArgsConstructor
public class UsuarioDaoImpl implements UsuarioDao {

	private final PasswordEncoder passwordEncoder;

	@Override
	public Optional<UsuarioEntidad> findByUsername(String username) {
		return llenar()
				.stream()
				.filter(usuarioEntidad -> usuarioEntidad.getUsuario().equals(username))
				.findFirst();
	}

	private List<UsuarioEntidad> llenar() {
		List<UsuarioEntidad> userEntities = Arrays.asList(
				new UsuarioEntidad(
						"pedro",
						passwordEncoder.encode("123456"),
						Arrays.asList(
								new SimpleGrantedAuthority("ROLE_ADMIN")
						)
				),
				new UsuarioEntidad(
						"andres",
						passwordEncoder.encode("123456"),
						Arrays.asList(
								new SimpleGrantedAuthority("ROL_SUMAR_ALCANCIA")
						)
				),
				new UsuarioEntidad(
						"julian",
						passwordEncoder.encode("123456"),
						Arrays.asList(
								new SimpleGrantedAuthority("ROL_VER_ALCANCIA")
						)
				)
		);
		return userEntities;
	}

}
