package edu.upc.taller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "Tipo_Pago")
@Data
public class TipoPago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_tipo_pago;
	@Size(max=150,message = "Solo hasta 150 caracteres")
	@Column(name = "Descripion")
	private String descripcion;
}
