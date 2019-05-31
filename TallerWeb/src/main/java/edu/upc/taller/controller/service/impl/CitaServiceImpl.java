package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.ICitaService;
import edu.upc.taller.model.Cita;
import edu.upc.taller.model.repository.ICitaRepository;

@Service
public class CitaServiceImpl implements ICitaService{

	@Autowired
	private ICitaRepository citaRepository;
	
	@Override
	public Cita registrar(Cita t) {
		return citaRepository.save(t);
	}

	@Override
	public Cita modificar(Cita t) {
		return citaRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		citaRepository.deleteById(id);
		
	}

	@Override
	public Optional<Cita> listarId(int id) {
		return citaRepository.findById(id);
	}

	@Override
	public List<Cita> listar() {
		return citaRepository.findAll();
	}

}
