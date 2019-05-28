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
@Table(name="proveedor")
@Data
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_proveedor;
	
	@Column(name="RUC", nullable = true, length = 11)
	private String RUC;
	
	@Size(min=3, message = "El nombre debe tener mínimo 3 caracteres")
	@Column(name="nombre", nullable = false, length = 60)
	private String nombre;
	
	@Column(name="telefono", nullable = true, length = 9)
	private String telefono;
	
	@Column(name="ciudad", nullable = false, length = 30)
	private String ciudad;
	
}
