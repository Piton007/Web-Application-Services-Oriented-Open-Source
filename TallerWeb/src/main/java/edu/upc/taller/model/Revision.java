package edu.upc.taller.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="Revision")
@Data
public class Revision {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_revision;
	@OneToOne
	@JoinColumn(name = "cita_id",nullable=false)
	private Cita cita;
	@Size(max = 150,message = "Solo 150 caracteres como maximo")
	@Column(name="Descripion")
	private String descripcion;
	@Temporal(TemporalType.DATE)
	@Column(name = "Fecha_Fin")
	private Date FFin;
}
