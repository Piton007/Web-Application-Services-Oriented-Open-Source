package edu.upc.taller.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Size(min=3,max = 20,message = "el nombre debe tener como minimo 3 caracteres")
	@Column(name = "Nombre",nullable=false)
	private String nombre;
	@Size(max = 150,message = "Solo 150 caracteres como maximo")
	@Column(name = "Descripcion")
	private String descripcion;
	@Column(name = "Costo_Serv",nullable=false)
	private double cost_serv;
	@OneToMany(mappedBy = "servicio",fetch = FetchType.LAZY,orphanRemoval = true)
	private List<DetServicio>detalles;
}
