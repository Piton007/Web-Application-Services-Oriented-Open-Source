package edu.upc.taller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "DetComprobante")
@Data
public class DetComprobante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_det_comprobante;
	@OneToOne
	@JoinColumn(name="detservicio_id")
	private DetServicio detservicio;
	@Column(name = "cant_serv")
	private int cant_serv;
	@Column(name = "Monto")
	private double Monto;
	@Column(name = "Descuento")
	private double Descuento;
}
