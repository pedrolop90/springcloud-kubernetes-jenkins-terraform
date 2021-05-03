package com.testing.springcloud.archivo.repositorio;

import com.testing.springcloud.archivo.entidad.ArchivoEntidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Pedro Lopez
 */
@Repository
public interface ArchivoRepositorio extends CrudRepository<ArchivoEntidad, String> {
}
