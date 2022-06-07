package com.efinanciera.EntidadFinanciera.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Clientes{

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@Column(name = "nombre", nullable = true, length = 80)
	private String nombre;
	
	@Column(name = "apellido", nullable = true, length = 250)
	private String apellido;
	
	@ManyToOne(targetEntity = TipoDocumento.class)
	@JoinColumn(name = "tipo_documento", nullable = true)
	private TipoDocumento tipo_documento;
	
	@Column(name = "no_documento")
	private String no_documento;
	
	@Column(name = "rut", nullable = false, unique = true)
	private String rut;
	
	@Column(name = "razon_social", nullable = true, length = 100)
	private String razon_social;
	
	@Column(name = "anio_fundacion", nullable = true)
	private String anio_fundacion;
	
	@ManyToOne(targetEntity = TipoPersona.class)
	@JoinColumn(name = "tipo_persona", nullable = false)
	private TipoPersona tipo_persona;
	
	@OneToMany(targetEntity = Clientes.class)
	@JoinColumn(name = "cuentas")
	private List<Cuentas> cuentas;
}
