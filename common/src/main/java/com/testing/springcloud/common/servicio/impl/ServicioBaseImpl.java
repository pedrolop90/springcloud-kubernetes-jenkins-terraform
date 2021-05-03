package com.testing.springcloud.common.servicio.impl;

import com.testing.springcloud.common.convertidor.ConvertidorBase;
import com.testing.springcloud.common.dto.IdEntidad;
import com.testing.springcloud.common.dto.Modelo;
import com.testing.springcloud.common.servicio.ServicioBase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class ServicioBaseImpl<ID, MODELO extends Modelo<ID>, ENTIDAD extends IdEntidad<ID>>
		implements ServicioBase<ID, MODELO> {

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public MODELO guardar(MODELO modelo) {
		ENTIDAD entidad = obtenerConversionBase().leftToRight(modelo);
		obtenerRepositorio().save(entidad);
		MODELO modeloResponse = obtenerConversionBase().rightToLeft(entidad);
		return modeloResponse;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Stream<MODELO> guardar(Iterable<MODELO> modelo) {
		Stream<ENTIDAD> entidades = obtenerConversionBase().leftToRight(modelo);
		Iterable<ENTIDAD> entidadesGuardadas = obtenerRepositorio()
				.saveAll(entidades.collect(Collectors.toList()));
		return obtenerConversionBase().rightToLeft(entidadesGuardadas);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void actualizar(MODELO modelo) {
		ENTIDAD entidad = obtenerConversionBase().leftToRight(modelo);
		obtenerRepositorio().save(entidad);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void actualizar(Iterable<MODELO> modelo) {
		Stream<ENTIDAD> entidades = obtenerConversionBase().leftToRight(modelo);
		obtenerRepositorio()
				.saveAll(entidades.collect(Collectors.toList()));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void actualizar(ID id, MODELO modelo) {
		modelo.setId(id);
		ENTIDAD entidad = obtenerConversionBase().leftToRight(modelo);
		obtenerRepositorio().save(entidad);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarPorId(ID id) {
		obtenerRepositorio().deleteById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void eliminarPorId(Iterable<ID> id) {
		Iterable<ENTIDAD> entidadesGuardadas = obtenerRepositorio().findAllById(id);
		obtenerRepositorio().deleteAll(entidadesGuardadas);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(MODELO modelo) {
		ENTIDAD entidad = obtenerConversionBase().leftToRight(modelo);
		obtenerRepositorio().delete(entidad);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public MODELO buscarPorId(ID id) {
		ENTIDAD entidad = obtenerRepositorio().findById(id).orElse(null);
		return obtenerConversionBase().rightToLeft(entidad);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Stream<MODELO> buscarPorId(Iterable<ID> id) {
		Iterable<ENTIDAD> entidadesGuardadas = obtenerRepositorio().findAllById(id);
		return obtenerConversionBase().rightToLeft(entidadesGuardadas);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Stream<MODELO> buscarTodo() {
		Iterable<ENTIDAD> entidadesGuardadas = obtenerRepositorio().findAll();
		return obtenerConversionBase().rightToLeft(entidadesGuardadas);
	}

	protected abstract CrudRepository<ENTIDAD, ID> obtenerRepositorio();

	protected abstract ConvertidorBase<MODELO, ENTIDAD> obtenerConversionBase();

}
