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
@Table(name="repuesto_proveedor_almacen")
@Data
public class Repuesto_proveedor_almacen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_repuesto_prov_alm;
	
	@ManyToOne
	@JoinColumn(name = "proveedor_id", nullable = false)
	private Proveedor provedor;
	
	@ManyToOne
	@JoinColumn(name = "almacen_id", nullable = false)
	private Almacen almacen;
	
	@ManyToOne
	@JoinColumn(name = "repuesto_id", nullable = false)
	private Repuesto repuesto;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso", nullable = false)
	private Date fecha_ingreso;
	
	@Column(name="cantidad", nullable = false)
	private int cantidad;
}
