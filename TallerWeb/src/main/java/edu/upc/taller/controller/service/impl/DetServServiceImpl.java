package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.IDetServService;
import edu.upc.taller.model.DetServicio;
import edu.upc.taller.model.repository.IDetServRepository;


@Service
public class DetServServiceImpl implements IDetServService {

	@Autowired
	private IDetServRepository det_serv_repository;
	@Override
	public DetServicio registrar(DetServicio t) {
		// TODO Auto-generated method stub
		return det_serv_repository.save(t);
	}

	@Override
	public DetServicio modificar(DetServicio t) {
		
		return det_serv_repository.save(t);
	}

	@Override
	public void eliminar(int id) {
		det_serv_repository.deleteById(id);
		
	}

	@Override
	public Optional<DetServicio> listarId(int id) {
		// TODO Auto-generated method stub
		return det_serv_repository.findById(id);
	}

	@Override
	public List<DetServicio> listar() {
	
		return det_serv_repository.findAll();
	}

}
