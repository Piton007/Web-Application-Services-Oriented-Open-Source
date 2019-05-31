package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.upc.taller.controller.service.IModeloService;
import edu.upc.taller.model.Modelo;
import edu.upc.taller.model.repository.IModeloRepository;

@Service
public class ModeloServiceImpl implements IModeloService{

	@Autowired
	private IModeloRepository modeloRepository;

	@Override
	public Modelo registrar(Modelo t) {
		return modeloRepository.save(t);
	}

	@Override
	public Modelo modificar(Modelo t) {
		return modeloRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		modeloRepository.deleteById(id);
		
	}

	@Override
	public Optional<Modelo> listarId(int id) {
		return modeloRepository.findById(id);
	}

	@Override
	public List<Modelo> listar() {
		return modeloRepository.findAll();
	}
	
}
