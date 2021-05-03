package com.testing.springcloud.zuul.seguridad.respuesta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pedro Lopez
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private String usuario;
    private String password;

}
