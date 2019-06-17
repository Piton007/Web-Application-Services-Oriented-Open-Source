package edu.upc.taller.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.upc.taller.model.Servicio;

public interface IServicioRepository extends JpaRepository<Servicio, Integer> {

}
