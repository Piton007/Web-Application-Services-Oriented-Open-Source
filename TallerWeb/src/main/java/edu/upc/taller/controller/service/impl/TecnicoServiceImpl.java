package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.ITecnicoService;
import edu.upc.taller.model.Tecnico;
import edu.upc.taller.model.repository.ITecnicoRepository;

@Service
public class TecnicoServiceImpl implements ITecnicoService{

	@Autowired
	private ITecnicoRepository tecnicoRepository;
	
	@Override
	public Tecnico registrar(Tecnico t) {
		return tecnicoRepository.save(t);
	}

	@Override
	public Tecnico modificar(Tecnico t) {
		return tecnicoRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		tecnicoRepository.deleteById(id);
	}

	@Override
	public Optional<Tecnico> listarId(int id) {
		return tecnicoRepository.findById(id);
	}

	@Override
	public List<Tecnico> listar() {
		return tecnicoRepository.findAll();
	}

}
