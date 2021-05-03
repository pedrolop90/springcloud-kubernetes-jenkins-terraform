package com.testing.springcloud.common.servicio;

import com.testing.springcloud.common.dto.Modelo;

import java.util.stream.Stream;

/**
 * @author Pedro Lopez
 */
public interface ServicioBase<ID, MODELO extends Modelo<ID>> {

	MODELO guardar(MODELO modelo);

	Stream<MODELO> guardar(Iterable<MODELO> modelo);

	void actualizar(MODELO modelo);

	void actualizar(Iterable<MODELO> modelo);

	void actualizar(ID id, MODELO modelo);

	void eliminarPorId(ID id);

	void eliminarPorId(Iterable<ID> id);

	void delete(MODELO modelo);

	MODELO buscarPorId(ID id);

	Stream<MODELO> buscarPorId(Iterable<ID> id);

	Stream<MODELO> buscarTodo();

}
