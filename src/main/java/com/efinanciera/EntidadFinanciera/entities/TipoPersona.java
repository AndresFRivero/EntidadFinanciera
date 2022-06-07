package com.efinanciera.EntidadFinanciera.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_persona")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoPersona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "tipo_persona", nullable = false)
	private String tipo_persona;

}
