package com.testing.springcloud.persona.convertidor;

import com.testing.springcloud.common.convertidor.ConvertidorBase;
import com.testing.springcloud.persona.entidad.PersonaEntidad;
import com.testing.springcloud.persona.modelo.PersonaModelo;
import org.mapstruct.Mapper;

/**
 * @author Pedro Lopez
 */
@Mapper(componentModel = "spring")
public interface PersonaModeloToPersonaEntidadConvertidor extends ConvertidorBase<PersonaModelo, PersonaEntidad> {
}
