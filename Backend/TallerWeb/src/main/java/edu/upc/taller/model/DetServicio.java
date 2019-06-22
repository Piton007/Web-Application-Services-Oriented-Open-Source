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
@Table(name = "Detalle_Servicio")
@Data
public class DetServicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_det_serv;
	@ManyToOne
	@JoinColumn(name = "servicio_id",nullable=false)
	private Servicio servicio;
	@ManyToOne
	@JoinColumn(name = "repuesto_id",nullable=false)
	private Repuesto repuesto;
	@ManyToOne
	@JoinColumn(name = "tecnico_id",nullable=false)
	private Tecnico tecnico;
	@Column(name = "Costo_Detalle",nullable=false)
	private double cost_detalle;
	@Temporal(TemporalType.DATE)
	@Column(name="Fech_serv", nullable = false)
	private Date Fech_serv;
	@Column(name="cant_rep",nullable=false)
	private int cant_rep;
}
