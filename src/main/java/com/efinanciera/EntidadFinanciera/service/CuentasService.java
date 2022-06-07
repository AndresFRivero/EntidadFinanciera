package com.efinanciera.EntidadFinanciera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.efinanciera.EntidadFinanciera.entities.Cuentas;
import com.efinanciera.EntidadFinanciera.repositories.CuentasRepository;

@Service
public class CuentasService {
	
	@Autowired
	private CuentasRepository cuentasRepository;
	
	public List<Cuentas> getAll(){
		return this.cuentasRepository.findAll();
	}
	
	public Cuentas create(Cuentas cuenta) {
		return this.cuentasRepository.save(cuenta);
	}
	
	public Cuentas update(Cuentas cuenta) {
		return this.cuentasRepository.save(cuenta);
	}
	
	public Cuentas delete(String no_cuenta) {
		Cuentas cuenta = null;
		for (Cuentas cu : this.getAll()) {
			if (cu.getNo_cuenta().equals(no_cuenta)) {
				cuenta = cu;
			}
			break;
		}
		if (cuenta != null) {
			this.cuentasRepository.delete(cuenta);
		}
		return cuenta;
	}
	
	public Cuentas getByNoCuenta(String no_cuenta) {
		Cuentas cuenta = null;
		for (Cuentas cu : this.getAll()) {
			if (cu.getNo_cuenta().equals(no_cuenta)) {
				cuenta = cu;
				break;
			}
		}
		return cuenta;
	}

}
