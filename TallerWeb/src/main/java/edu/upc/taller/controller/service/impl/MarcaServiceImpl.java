package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.upc.taller.controller.service.IMarcaService;
import edu.upc.taller.model.Marca;

import edu.upc.taller.model.repository.IMarcaRepository;

@Service
public class MarcaServiceImpl implements IMarcaService {

	
	@Autowired
	private IMarcaRepository marcaRepository;
	
	@Override
	public Marca registrar(Marca t) {
		return marcaRepository.save(t);
	}

	@Override
	public Marca modificar(Marca t) {
		return marcaRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		marcaRepository.deleteById(id);
		
	}

	@Override
	public Optional<Marca> listarId(int id) {
		return marcaRepository.findById(id);
	}

	@Override
	public List<Marca> listar() {
		return marcaRepository.findAll();
	}

}
