package edu.upc.taller.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.upc.taller.model.Cliente;



public interface IClienteRepository extends JpaRepository<Cliente, Integer>{

}
