package edu.upc.taller.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "Servicio")
@Data
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_servicio;

	@Size(max = 150,message = "Solo 150 caracteres como maximo")
	@Column(name = "Descripcion")
	private String descripcion;
	@Column(name = "Costo_Serv",nullable=false)
	private double cost_serv;
	@ManyToOne
	@JoinColumn(name="Cita_Id",nullable=false)
	private Cita Cita_Id;
}
