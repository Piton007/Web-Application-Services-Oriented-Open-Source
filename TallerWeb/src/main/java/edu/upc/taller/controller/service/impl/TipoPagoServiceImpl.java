package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.ITipoPagoService;
import edu.upc.taller.model.TipoPago;

import edu.upc.taller.model.repository.ITipoPagoRepository;

@Service
public class TipoPagoServiceImpl implements ITipoPagoService{
	
	@Autowired
	private ITipoPagoRepository tipo_pago_repository;
	
	@Override
	public TipoPago registrar(TipoPago t) {
		// TODO Auto-generated method stub
		return tipo_pago_repository.save(t);
	}

	@Override
	public TipoPago modificar(TipoPago t) {
		// TODO Auto-generated method stub
		return tipo_pago_repository.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		tipo_pago_repository.deleteById(id);
	}

	@Override
	public Optional<TipoPago> listarId(int id) {
		// TODO Auto-generated method stub
		return tipo_pago_repository.findById(id);
	}

	@Override
	public List<TipoPago> listar() {
		// TODO Auto-generated method stub
		return tipo_pago_repository.findAll();
	}

}
