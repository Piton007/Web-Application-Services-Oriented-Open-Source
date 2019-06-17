package edu.upc.taller.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.upc.taller.model.Revision;

public interface IRevisionRepository extends JpaRepository<Revision, Integer> {

}
