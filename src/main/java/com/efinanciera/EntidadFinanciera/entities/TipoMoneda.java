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
@Table(name = "tipo_moneda")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoMoneda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "tipo_moneda", nullable = false)
	private String tipo_moneda;
}
