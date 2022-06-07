package com.efinanciera.EntidadFinanciera.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movimientos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movimientos {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@Column(name = "valor", nullable = false)
	private Float valor;
	
	@Column(name = "fecha", nullable = false)
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date fecha;
	
	@Column(name = "descripcion", nullable = false)
	private Integer descripcion;
	
	@ManyToOne(targetEntity = Cuentas.class)
	@JoinColumn(name = "cuenta")
	private Cuentas cuenta;
}
