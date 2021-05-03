package com.testing.springcloud.zuul.seguridad.configuracion;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Pedro Lopez
 */
@Component
@ConfigurationProperties(prefix = "jwt")
@RequiredArgsConstructor
@Getter
@Setter
@Validated
public class JwtPropiedades {

	@NotBlank
	private String secretKey;
	@NotBlank
	private String prefix;
	@NotNull
	private Integer expiraInDays;

}
