package com.efinanciera.EntidadFinanciera.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cuentas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cuentas{

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@Column(name = "no_cuenta", nullable = false)
	private String no_cuenta;
	
	@ManyToOne(targetEntity = TipoMoneda.class)
	@JoinColumn(name = "tipo_moneda", nullable = false)
	private TipoMoneda tipo_moneda;
	
	@Column(name = "saldo", nullable = false)
	private Float saldo;
}
