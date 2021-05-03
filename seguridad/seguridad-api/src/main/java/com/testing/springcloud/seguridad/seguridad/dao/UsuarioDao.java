package com.testing.springcloud.seguridad.seguridad.dao;



import com.testing.springcloud.seguridad.seguridad.entidad.UsuarioEntidad;

import java.util.Optional;

/**
 * @author Pedro Lopez
 */
public interface UsuarioDao {

	Optional<UsuarioEntidad> findByUsername(String username);

}
