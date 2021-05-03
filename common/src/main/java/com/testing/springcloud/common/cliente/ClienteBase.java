package com.testing.springcloud.common.cliente;

import com.testing.springcloud.common.dto.Modelo;
import com.testing.springcloud.common.respuesta.ListaObjetoRespuesta;
import com.testing.springcloud.common.respuesta.ObjectoRespuesta;
import com.testing.springcloud.common.respuesta.RespuestaBase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ClienteBase<ID, MODELO extends Modelo<ID>> {

	@PostMapping
	ObjectoRespuesta<MODELO> guardar(@RequestBody MODELO modelo);

	@PostMapping("/batch")
	ListaObjetoRespuesta<MODELO> guardar(@RequestBody Iterable<MODELO> modelo);

	@PutMapping("/{id}")
	RespuestaBase actualizar(@PathVariable("id") ID id, @RequestBody MODELO modelo);

	@PutMapping("/batch")
	RespuestaBase actualizar(@RequestBody Iterable<MODELO> modelo);

	@DeleteMapping("/{id}")
	RespuestaBase eliminarPorId(@PathVariable("id") ID id);

	@DeleteMapping("/batch")
	RespuestaBase eliminarPorId(@RequestBody Iterable<ID> id);

	@GetMapping("/{id}")
	ObjectoRespuesta<MODELO> buscarPorId(@PathVariable("id") ID id);

	@GetMapping
	ListaObjetoRespuesta<MODELO> buscarTodo();

}
