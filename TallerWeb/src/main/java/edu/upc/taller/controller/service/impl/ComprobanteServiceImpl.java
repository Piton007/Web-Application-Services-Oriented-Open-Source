package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.IComprobanteService;
import edu.upc.taller.model.Comprobante;
import edu.upc.taller.model.repository.IComprobanteRepository;
@Service 
public class ComprobanteServiceImpl implements IComprobanteService {
	
	@Autowired
	private IComprobanteRepository comprobanterepository;
	@Override
	public Comprobante registrar(Comprobante t) {
		// TODO Auto-generated method stub
		return comprobanterepository.save(t);
	}

	@Override
	public Comprobante modificar(Comprobante t) {
		// TODO Auto-generated method stub
		return comprobanterepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		comprobanterepository.deleteById(id);
		
	}

	@Override
	public Optional<Comprobante> listarId(int id) {
		// TODO Auto-generated method stub
		return comprobanterepository.findById(id);
	}

	@Override
	public List<Comprobante> listar() {
		// TODO Auto-generated method stub
		return comprobanterepository.findAll();
	}

}
