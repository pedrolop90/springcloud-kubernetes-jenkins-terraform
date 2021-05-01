package com.testing.springcloud.common.controlador.impl;

import com.testing.springcloud.common.controlador.ControladorBase;
import com.testing.springcloud.common.dto.IdEntidad;
import com.testing.springcloud.common.dto.Modelo;
import com.testing.springcloud.common.servicio.ServicioBase;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.stream.Stream;

public abstract class ControladorBaseImpl<ID, MODELO extends Modelo<ID>, ENTIDAD extends IdEntidad<ID>>
		implements ControladorBase<ID, MODELO> {

	@Override
	@PostMapping
	public MODELO guardar(@RequestBody MODELO modelo) {
		return obtenerServicio().guardar(modelo);
	}

	@Override
	@PostMapping("/batch")
	public Stream<MODELO> guardar(@RequestBody Iterable<MODELO> modelo) {
		return obtenerServicio().guardar(modelo);
	}

	@Override
	@PutMapping("/{id}")
	public void actualizar(@PathVariable ID id, @RequestBody MODELO modelo) {
		obtenerServicio().actualizar(id, modelo);
	}

	@Override
	@PutMapping("/batch")
	public void actualizar(@RequestBody Iterable<MODELO> modelo) {
		obtenerServicio().actualizar(modelo);
	}


	@Override
	@DeleteMapping("/{id}")
	public void eliminarPorId(@PathVariable ID id) {
		obtenerServicio().eliminarPorId(id);
	}

	@Override
	@DeleteMapping("/batch")
	public void eliminarPorId(@RequestBody Iterable<ID> id) {
		obtenerServicio().eliminarPorId(id);
	}

	@Override
	@GetMapping("/{id}")
	public MODELO buscarPorId(@PathVariable ID id) {
		return obtenerServicio().buscarPorId(id);
	}

	@Override
	@GetMapping
	public Stream<MODELO> buscarTodo() {
		return obtenerServicio().buscarTodo();
	}

	public abstract ServicioBase<ID, MODELO> obtenerServicio();
}
