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
@Table(name="cliente")
@Data
public class Cliente {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Size(min=3, message = "El nombre debe tener mínimo 3 caracteres")
	@Column(name="nombre", nullable = false, length = 60)
	private String nombre;
	@Size(min=3, message = "El apellido debe tener mínimo 3 caracteres")
	@Column(name="apellido", nullable = true, length = 11)
	private String apellido;
	@Column(name="dni", nullable = false, length = 8)
	private String dni;
	@Column(name="telefono", nullable = true, length = 9)
	private String telefono;
	
	

}
