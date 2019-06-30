package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.IDetServService;
import edu.upc.taller.model.DetServicio;
import edu.upc.taller.model.Repuesto_proveedor_almacen;
import edu.upc.taller.model.repository.IDetServRepository;
import edu.upc.taller.model.repository.IRepuesto_proveedor_almacenRepository;


@Service
public class DetServServiceImpl implements IDetServService {

	@Autowired
	private IDetServRepository det_serv_repository;
	@Override
	public DetServicio registrar(DetServicio t) {
		// TODO Auto-generated method stub
		
		double costo=t.getRepuestoDet().getRepuesto().getPrecio()*t.getCant_rep();
		t.setCost_detalle(costo);

		int desc=t.getRepuestoDet().getCantidad()-t.getCant_rep();
		t.getRepuestoDet().setCantidad(desc);

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
