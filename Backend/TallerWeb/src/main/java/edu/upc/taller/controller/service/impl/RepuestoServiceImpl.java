package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.IRepuestoService;
import edu.upc.taller.model.Repuesto;
import edu.upc.taller.model.repository.IRepuestoRepository;

@Service
public class RepuestoServiceImpl implements IRepuestoService{

	@Autowired
	private IRepuestoRepository repuestoRepository;
	
	@Override
	public Repuesto registrar(Repuesto t) {
		if(t.getPrecio()>0)
		return repuestoRepository.save(t);
		else {
			return new Repuesto();
		}
	}

	@Override
	public Repuesto modificar(Repuesto t) {
		return repuestoRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		repuestoRepository.deleteById(id);
	}

	@Override
	public Optional<Repuesto> listarId(int id) {
		return repuestoRepository.findById(id);
	}

	@Override
	public List<Repuesto> listar() {
		return repuestoRepository.findAll();
	}

}
