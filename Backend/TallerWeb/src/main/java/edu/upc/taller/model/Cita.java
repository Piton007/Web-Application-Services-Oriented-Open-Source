package edu.upc.taller.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import lombok.Data;

@Entity
@Table(name="cita")
@Data
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cod_vehiculo", nullable=false)
	private Cliente cod_vehiculo;
	
	@ManyToOne
	@JoinColumn(name="cod_asistente", nullable=false)
	private Cliente cod_asistente;
	
	@Column(name="descripcion", nullable = false, length = 50)
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_reserva", nullable = false)
	private Date fecha_reserva;
	
	@Column(name = "estado_cita", nullable = false)
	private int estado_cita;

}
