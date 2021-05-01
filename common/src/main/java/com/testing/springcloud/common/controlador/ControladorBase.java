package com.testing.springcloud.common.controlador;

import com.testing.springcloud.common.dto.Modelo;

import java.util.stream.Stream;

public interface ControladorBase<ID, MODELO extends Modelo<ID>> {

	MODELO guardar(MODELO modelo);

	Stream<MODELO> guardar(Iterable<MODELO> modelo);

	void actualizar(Iterable<MODELO> modelo);

	void actualizar(ID id, MODELO modelo);

	void eliminarPorId(ID id);

	void eliminarPorId(Iterable<ID> id);

	MODELO buscarPorId(ID id);

	Stream<MODELO> buscarTodo();

}
