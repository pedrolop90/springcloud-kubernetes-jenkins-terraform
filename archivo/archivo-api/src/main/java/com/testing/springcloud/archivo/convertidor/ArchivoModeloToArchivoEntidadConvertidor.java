package com.testing.springcloud.archivo.convertidor;

import com.testing.springcloud.archivo.entidad.ArchivoEntidad;
import com.testing.springcloud.archivo.modelo.ArchivoModelo;
import com.testing.springcloud.common.convertidor.ConvertidorBase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArchivoModeloToArchivoEntidadConvertidor
		extends ConvertidorBase<ArchivoModelo, ArchivoEntidad> {
}
