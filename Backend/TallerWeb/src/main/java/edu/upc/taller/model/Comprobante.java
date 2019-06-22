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
@Table(name = "Comprobante")
@Data
public class Comprobante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_comprobante;
	@Column(name = "TipoComprobante")
	private int tipo_comprobante;
	@Temporal(TemporalType.DATE)
	@Column(name = "Fecha")
	private Date Fecha;
	@ManyToOne
	@JoinColumn(name = "cliente_id",nullable=false)
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "Tpago_id",nullable=false)
	private TipoPago tipopago;
}
