package edu.upc.taller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="modelo")
@Data
public class Modelo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="nombre_modelo", nullable = false, length = 20)
	private String nombre_modelo;

	
	@ManyToOne
	@JoinColumn(name="cod_marca", nullable=false)
	private Cliente cod_marca;
	
	

}
