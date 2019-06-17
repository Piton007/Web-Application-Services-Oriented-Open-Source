package edu.upc.taller.controller.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.upc.taller.controller.service.IRevisionService;
import edu.upc.taller.model.Revision;
import edu.upc.taller.model.repository.IRevisionRepository;

@Service
public class RevisionServiceImpl implements IRevisionService {

	@Autowired
	private IRevisionRepository revision_repository;
	@Override
	public Revision registrar(Revision t) {
		// TODO Auto-generated method stub
		return revision_repository.save(t);
	}

	@Override
	public Revision modificar(Revision t) {
		// TODO Auto-generated method stub
		return revision_repository.save(t);
	}

	@Override
	public void eliminar(int id) {
		revision_repository.deleteById(id);
		
	}

	@Override
	public Optional<Revision> listarId(int id) {
		// TODO Auto-generated method stub
		return revision_repository.findById(id);
	}

	@Override
	public List<Revision> listar() {
		// TODO Auto-generated method stub
		return revision_repository.findAll();
	}

}
