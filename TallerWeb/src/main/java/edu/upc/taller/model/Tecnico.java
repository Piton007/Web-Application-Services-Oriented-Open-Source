package edu.upc.taller.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="tecnico")
@Data
public class Tecnico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_tecnico;
	
	@Size(min=3, message = "Los nombres deben tener mínimo 3 caracteres")
	@Column(name="nombres", nullable = false, length = 60)
	private String nombres_tecnico;
	
	@Size(min=3, message = "Los apellidos deben tener mínimo 3 caracteres")
	@Column(name="apellidos", nullable = false, length = 60)
	private String apellidos_tecnico;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso", nullable = false)
	private Date fecha_ingreso;
	
	@Column(name = "disponibilidad", nullable = false)
	private int disponibilidad;
	
	@Size(min=8, message = "EL dni debe tener 8 digitos")
	@Column(name="dni", nullable = false, length = 8)
	private String dni;
}
