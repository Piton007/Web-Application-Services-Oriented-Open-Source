package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.upc.taller.controller.service.IVehiculoService;
import edu.upc.taller.model.Vehiculo;

import edu.upc.taller.model.repository.IVehiculoRepository;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

	@Autowired
	private IVehiculoRepository vehiculoRepository;
	
	
	@Override
	public Vehiculo registrar(Vehiculo t) {
		return vehiculoRepository.save(t);
	}

	@Override
	public Vehiculo modificar(Vehiculo t) {
		return vehiculoRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		vehiculoRepository.deleteById(id);
		
	}

	@Override
	public Optional<Vehiculo> listarId(int id) {
		return vehiculoRepository.findById(id);
	}

	@Override
	public List<Vehiculo> listar() {
		return vehiculoRepository.findAll();
	}

}
