package edu.upc.taller.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.upc.taller.model.Modelo;

public interface IModeloRepository extends JpaRepository<Modelo, Integer> {

}
