package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.IDetComprobanteService;
import edu.upc.taller.model.DetComprobante;
import edu.upc.taller.model.repository.IDetComprobanteRepository;

@Service
public class DetComprobanteServiceImpl implements IDetComprobanteService {

	@Autowired
	private IDetComprobanteRepository comprobanterepository;
	@Override
	public DetComprobante registrar(DetComprobante t) {
		// TODO Auto-generated method stub
		return comprobanterepository.save(t);
	}

	@Override
	public DetComprobante modificar(DetComprobante t) {
		// TODO Auto-generated method stub
		return comprobanterepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		comprobanterepository.deleteById(id);
		
	}

	@Override
	public Optional<DetComprobante> listarId(int id) {
		// TODO Auto-generated method stub
		return  comprobanterepository.findById(id);
	}

	@Override
	public List<DetComprobante> listar() {
		// TODO Auto-generated method stub
		return comprobanterepository.findAll();
	}
	
}
