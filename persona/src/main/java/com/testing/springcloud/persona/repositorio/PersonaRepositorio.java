package com.testing.springcloud.persona.repositorio;

import com.testing.springcloud.persona.entidad.PersonaEntidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends CrudRepository<PersonaEntidad, Long> {
}
