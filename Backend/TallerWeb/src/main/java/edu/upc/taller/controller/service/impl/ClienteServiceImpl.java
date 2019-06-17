package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.IClienteService;
import edu.upc.taller.model.Cliente;
import edu.upc.taller.model.repository.IClienteRepository;



@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteRepository clienteRepository;
	
	@Override
	public Cliente registrar(Cliente t) {
		return clienteRepository.save(t);
	}

	@Override
	public Cliente modificar(Cliente t) {
		return clienteRepository.save(t);
	}

	@Override
	public void eliminar(int id) {
		clienteRepository.deleteById(id);
		
	}

	@Override
	public Optional<Cliente> listarId(int id) {
		return clienteRepository.findById(id);
	}

	@Override
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

}
