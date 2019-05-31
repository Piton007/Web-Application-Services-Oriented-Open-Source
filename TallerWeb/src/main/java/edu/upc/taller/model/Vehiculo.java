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
@Table(name="vehiculo")
@Data
public class Vehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="numero_placa", nullable = false, length = 9)
	private String numero_placa;
	
	@Column(name="año", nullable = false, length =4)
	private int año;
	
	@ManyToOne
	@JoinColumn(name="cod_modelo", nullable=false)
	private Cliente cod_modelo;
	
	@Column(name="color", nullable = false, length = 15)
	private String color;
	
	@Column(name="numero_serie_motor", nullable = false, length = 15)
	private String numero_serie_motor;
	
	@ManyToOne
	@JoinColumn(name="cod_cliente", nullable=false)
	private Cliente cod_cliente;
	
	@Column(name="tipo_vehiculo", nullable = false, length = 30)
	private String tipo_vehiculo;
	
	
}
