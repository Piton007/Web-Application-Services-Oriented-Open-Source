package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.IAsistenteService;
import edu.upc.taller.model.Asistente;
import edu.upc.taller.model.repository.IAsistenteRepository;

@Service
public class AsistenteServiceImpl implements IAsistenteService {

	@Autowired
	private IAsistenteRepository asistenteRepository;
	
	
	@Override
	public Asistente registrar(Asistente t) {
		return asistenteRepository.save(t);
	}

	@Override
	public Asistente modificar(Asistente t) {
		return asistenteRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		asistenteRepository.deleteById(id);
		
	}

	@Override
	public Optional<Asistente> listarId(int id) {
		return asistenteRepository.findById(id);
	}

	@Override
	public List<Asistente> listar() {
		return asistenteRepository.findAll();
	}

}
