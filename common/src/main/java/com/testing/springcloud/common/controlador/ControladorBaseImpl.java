package com.testing.springcloud.common.controlador;

import com.testing.springcloud.common.dto.IdEntidad;
import com.testing.springcloud.common.dto.Modelo;
import com.testing.springcloud.common.respuesta.ListaObjetoRespuesta;
import com.testing.springcloud.common.respuesta.ObjectoRespuesta;
import com.testing.springcloud.common.servicio.ServicioBase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class ControladorBaseImpl<ID, MODELO extends Modelo<ID>, ENTIDAD extends IdEntidad<ID>> {

	@PostMapping
	public ObjectoRespuesta<MODELO> guardar(@RequestBody MODELO modelo) {
		return new ObjectoRespuesta<>(
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
	public void actualizar(@PathVariable ID id, @RequestBody MODELO modelo) {
		obtenerServicio().actualizar(id, modelo);
	}

	@PutMapping("/batch")
	public void actualizar(@RequestBody Iterable<MODELO> modelo) {
		obtenerServicio().actualizar(modelo);
	}

	@DeleteMapping("/{id}")
	public void eliminarPorId(@PathVariable ID id) {
		obtenerServicio().eliminarPorId(id);
	}

	@DeleteMapping("/batch")
	public void eliminarPorId(@RequestBody Iterable<ID> id) {
		obtenerServicio().eliminarPorId(id);
	}

	@GetMapping("/{id}")
	public ObjectoRespuesta<MODELO> buscarPorId(@PathVariable ID id) {
		return new ObjectoRespuesta<>(
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
