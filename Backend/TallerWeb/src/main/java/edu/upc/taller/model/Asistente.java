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
@Table(name="asistente")
@Data
public class Asistente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=3, message = "Los nombres deben tener mínimo 3 caracteres")
	@Column(name="nombre_asistente", nullable = false, length = 60)
	private String nombre_asistente;
	
	@Size(min=3, message = "Los apellidos deben tener mínimo 3 caracteres")
	@Column(name="apellido_asistente", nullable = false, length = 60)
	private String apellido_asistente;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso_asistente", nullable = false)
	private Date fecha_ingreso_asistente;
	
	@Column(name = "disponibilidad", nullable = false)
	private int disponibilidad;
	
	@Column(name = "tarifa", nullable = false)
	private int tarifa;
	
	@Size(min=8, message = "EL dni debe tener 8 digitos")
	@Column(name="dni_asistente", nullable = false, length = 8)
	private String dni_asistente;

}
