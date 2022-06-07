package com.efinanciera.EntidadFinanciera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efinanciera.EntidadFinanciera.entities.Clientes;
import com.efinanciera.EntidadFinanciera.repositories.ClientesRepository;

@Service
public class ClientesService {

	@Autowired
	private ClientesRepository clientesRepository;

	public List<Clientes> getAll() {
		return this.clientesRepository.findAll();
	}

	public Clientes create(Clientes clientes) {
		this.clientesRepository.save(clientes);
		return clientes;
	}
	
	public Clientes update(Clientes clientes) {
		this.clientesRepository.save(clientes);
		return clientes;
	}

	public Clientes delete(String rut) {
		Clientes cliente = null;
		for (Clientes cl : this.getAll()) {
			if (cl.getRut().equals(rut)) {
				cliente = cl;
			}
			break;
		}
		if (cliente != null) {
			this.clientesRepository.delete(cliente);
		}
		return cliente;
	}

	public Clientes getByRut(String rut) {
		Clientes cliente = null;
		for (Clientes cl : this.getAll()) {
			if (cl.getRut().equals(rut)) {
				cliente = cl;
			}
			break;
		}
		return cliente;
	}
}
