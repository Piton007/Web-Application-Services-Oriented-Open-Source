package edu.upc.taller.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import edu.upc.taller.model.Vehiculo;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer> {

}
