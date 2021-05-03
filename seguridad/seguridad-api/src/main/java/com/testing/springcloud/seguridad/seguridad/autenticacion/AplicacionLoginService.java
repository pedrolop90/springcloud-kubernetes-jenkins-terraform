package com.testing.springcloud.seguridad.seguridad.autenticacion;

import com.testing.springcloud.seguridad.seguridad.dao.UsuarioDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Pedro Lopez
 */
@Component
@RequiredArgsConstructor
public class AplicacionLoginService implements UserDetailsService {

    private final UsuarioDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioDao
                .findByUsername(username)
                .map(applicationUser ->
                        new User(
                                applicationUser.getUsuario(),
                                applicationUser.getPassword(),
                                applicationUser.getPermisos()
                        )
                )
                .get();
    }
}
