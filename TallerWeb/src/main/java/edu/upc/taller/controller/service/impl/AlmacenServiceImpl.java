package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.IAlmacenService;
import edu.upc.taller.model.Almacen;
import edu.upc.taller.model.repository.IAlmacenRepository;

@Service
public class AlmacenServiceImpl implements IAlmacenService{

	@Autowired
	private IAlmacenRepository almacenRepository;
	
	@Override
	public Almacen registrar(Almacen t) {
		return almacenRepository.save(t);
	}

	@Override
	public Almacen modificar(Almacen t) {
		return almacenRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		almacenRepository.deleteById(id);
	}

	@Override
	public Optional<Almacen> listarId(int id) {
		return almacenRepository.findById(id);
	}

	@Override
	public List<Almacen> listar() {
		return almacenRepository.findAll();
	}

}
