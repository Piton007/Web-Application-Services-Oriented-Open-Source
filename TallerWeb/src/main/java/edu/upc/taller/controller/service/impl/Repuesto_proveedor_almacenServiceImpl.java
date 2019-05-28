package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.IRepuesto_proveedor_almacenService;
import edu.upc.taller.model.Repuesto_proveedor_almacen;
import edu.upc.taller.model.repository.IRepuesto_proveedor_almacenRepository;

@Service
public class Repuesto_proveedor_almacenServiceImpl implements IRepuesto_proveedor_almacenService{

	@Autowired
	private IRepuesto_proveedor_almacenRepository rpaRepository;
	
	@Override
	public Repuesto_proveedor_almacen registrar(Repuesto_proveedor_almacen t) {
		return rpaRepository.save(t);
	}

	@Override
	public Repuesto_proveedor_almacen modificar(Repuesto_proveedor_almacen t) {
		return rpaRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		rpaRepository.deleteById(id);
	}

	@Override
	public Optional<Repuesto_proveedor_almacen> listarId(int id) {
		return rpaRepository.findById(id);
	}

	@Override
	public List<Repuesto_proveedor_almacen> listar() {
		return rpaRepository.findAll();
	}

}
