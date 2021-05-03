package com.testing.springcloud.zuul.seguridad.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @author Pedro Lopez
 */
@Data
@AllArgsConstructor
public class UsuarioEntidad {

    private String usuario;
    private String password;
    private List<GrantedAuthority> permisos;

}
