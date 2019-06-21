package edu.upc.taller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="repuesto")
@Data
public class Repuesto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_repuesto;
	
	@Size(min=3, message = "El nombre debe tener mínimo 3 caracteres")
	@Column(name="nombre", nullable = false, length = 60)
	private String nombre;
	
	@Column(name="precio", nullable = false)
	private double precio;

}
