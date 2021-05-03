package com.testing.springcloud.common.controlador;

import com.testing.springcloud.common.cliente.ClienteBase;
import com.testing.springcloud.common.dto.Modelo;
import com.testing.springcloud.common.respuesta.ListaObjetoRespuesta;
import com.testing.springcloud.common.respuesta.ObjetoRespuesta;
import com.testing.springcloud.common.respuesta.RespuestaBase;
import com.testing.springcloud.common.servicio.ServicioBase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author pedro
 */
public abstract class ControladorBaseImpl<ID, MODELO extends Modelo<ID>>
		implements ClienteBase<ID, MODELO> {

	@PostMapping
	public ObjetoRespuesta<MODELO> guardar(@RequestBody MODELO modelo) {
		return new ObjetoRespuesta<>(
				obtenerServicio().guardar(modelo)
		);
	}

	@PostMapping("/batch")
	public ListaObjetoRespuesta<MODELO> guardar(@RequestBody Iterable<MODELO> modelo) {
		return new ListaObjetoRespuesta<>(
				obtenerServicio().guardar(modelo)
		);
	}

	@PutMapping("/{id}")
	public RespuestaBase actualizar(@PathVariable ID id, @RequestBody MODELO modelo) {
		obtenerServicio().actualizar(id, modelo);
		return new RespuestaBase("Actualizacion Exitosa");
	}

	@PutMapping("/batch")
	public RespuestaBase actualizar(@RequestBody Iterable<MODELO> modelo) {
		obtenerServicio().actualizar(modelo);
		return new RespuestaBase("Actualizacion Exitosa");
	}

	@DeleteMapping("/{id}")
	public RespuestaBase eliminarPorId(@PathVariable ID id) {
		obtenerServicio().eliminarPorId(id);
		return new RespuestaBase("Actualizacion Exitosa");
	}

	@DeleteMapping("/batch")
	public RespuestaBase eliminarPorId(@RequestBody Iterable<ID> id) {
		obtenerServicio().eliminarPorId(id);
		return new RespuestaBase("Actualizacion Exitosa");
	}

	@GetMapping("/{id}")
	public ObjetoRespuesta<MODELO> buscarPorId(@PathVariable ID id) {
		return new ObjetoRespuesta<>(
				obtenerServicio().buscarPorId(id)
		);
	}

	@GetMapping
	public ListaObjetoRespuesta<MODELO> buscarTodo() {
		return new ListaObjetoRespuesta<>(
				obtenerServicio().buscarTodo()
		);
	}

	public abstract ServicioBase<ID, MODELO> obtenerServicio();
}
