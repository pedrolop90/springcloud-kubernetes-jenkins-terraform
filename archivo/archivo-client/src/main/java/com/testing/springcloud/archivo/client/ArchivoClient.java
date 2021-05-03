package com.testing.springcloud.archivo.client;

import com.testing.springcloud.archivo.modelo.ArchivoModelo;
import com.testing.springcloud.common.cliente.ClienteBase;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "archivo-testing", path = "archivos")
public interface ArchivoClient extends ClienteBase<String, ArchivoModelo> {
}
