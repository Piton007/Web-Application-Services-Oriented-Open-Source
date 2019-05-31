package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.IServServicie;
import edu.upc.taller.model.Servicio;
import edu.upc.taller.model.repository.IServicioRepository;

@Service
public class ServServiceImpl implements IServServicie {

	@Autowired
	private IServicioRepository servicio_repository;
	@Override
	public Servicio registrar(Servicio t) {
		// TODO Auto-generated method stub
		return servicio_repository.save(t);
	}

	@Override
	public Servicio modificar(Servicio t) {
		// TODO Auto-generated method stub
		return servicio_repository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		servicio_repository.findById(id);
		
	}

	@Override
	public Optional<Servicio> listarId(int id) {
		// TODO Auto-generated method stub
		return servicio_repository.findById(id);
	}

	@Override
	public List<Servicio> listar() {
		// TODO Auto-generated method stub
		return servicio_repository.findAll();
	}

}
