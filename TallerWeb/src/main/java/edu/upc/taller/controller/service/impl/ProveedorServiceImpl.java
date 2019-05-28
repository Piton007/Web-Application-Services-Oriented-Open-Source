package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.IProveedorService;
import edu.upc.taller.model.Proveedor;
import edu.upc.taller.model.repository.IProveedorRepository;

@Service
public class ProveedorServiceImpl implements IProveedorService{

	@Autowired
	private IProveedorRepository proveedorRepository;
	
	@Override
	public Proveedor registrar(Proveedor t) {
		return proveedorRepository.save(t);
	}

	@Override
	public Proveedor modificar(Proveedor t) {
		return proveedorRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		proveedorRepository.deleteById(id);
	}

	@Override
	public Optional<Proveedor> listarId(int id) {
		return proveedorRepository.findById(id);
	}

	@Override
	public List<Proveedor> listar() {
		return proveedorRepository.findAll();
	}

}
