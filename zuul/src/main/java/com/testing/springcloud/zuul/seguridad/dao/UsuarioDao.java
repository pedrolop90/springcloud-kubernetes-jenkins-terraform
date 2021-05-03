package com.testing.springcloud.zuul.seguridad.dao;


import com.testing.springcloud.zuul.seguridad.entidad.UsuarioEntidad;

import java.util.Optional;

/**
 * @author Pedro Lopez
 */
public interface UsuarioDao {

	Optional<UsuarioEntidad> findByUsername(String username);

}
