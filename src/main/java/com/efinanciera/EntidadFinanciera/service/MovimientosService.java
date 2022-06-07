package com.efinanciera.EntidadFinanciera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efinanciera.EntidadFinanciera.entities.Movimientos;
import com.efinanciera.EntidadFinanciera.repositories.MovimientoRepository;

@Service
public class MovimientosService {
	
	@Autowired
	private MovimientoRepository movimientoRepository;

	public List<Movimientos> getAll(){
		return this.movimientoRepository.findAll();
	}
	
	public Movimientos create(Movimientos movimientos) {
		return this.movimientoRepository.save(movimientos);
	}
}
