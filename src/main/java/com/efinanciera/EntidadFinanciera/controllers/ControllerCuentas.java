package com.efinanciera.EntidadFinanciera.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.efinanciera.EntidadFinanciera.entities.Cuentas;
import com.efinanciera.EntidadFinanciera.service.CuentasService;

@RestController
@RequestMapping("/cuentas")
public class ControllerCuentas {
	
	@Autowired
	private CuentasService cuentasService;
	
	@GetMapping("/")
	public List<Cuentas> getAll() {
		return this.cuentasService.getAll();
	}

	@PostMapping("/create")
	public String create(@RequestBody Cuentas cuenta) {
		Cuentas cuNo = this.cuentasService.getByNoCuenta(cuenta.getNo_cuenta());
		String msg = "";
		if (cuNo == null) {
			this.cuentasService.create(cuenta);
			msg = "Cuenta Registrada: \n";
		} else {
			msg = "No podemos registrar la cuenta por NO CUENTA ya registrado";
		}

		return msg + cuenta.toString();
	}

	@PutMapping("/update")
	public String update(@RequestBody Cuentas cuenta) {
		String msg = "";
		Cuentas cuNo = this.cuentasService.getByNoCuenta(cuenta.getNo_cuenta());
		if (cuNo != null) {
			cuNo.setSaldo(cuenta.getSaldo());
			this.cuentasService.update(cuNo);
			msg = "Cuenta Actualizada con NO CUENTA: " + cuenta.getNo_cuenta();
		}else {
			msg = "No se encontro cuenta relacionada: \n";
		}
		return msg;
	}

	@GetMapping("/getByNoCuenta")
	public Cuentas getByNoCuenta(@RequestParam("no_cuenta") String no_cuenta) {
		Cuentas cu = null;
		if (this.cuentasService.getByNoCuenta(no_cuenta) != null) {
			cu = this.cuentasService.getByNoCuenta(no_cuenta);
		} else {
			System.out.println("No hay registro de: " + no_cuenta);
		}
		return cu;
	}

	@DeleteMapping("/delete")
	public String delete(@RequestParam("no_cuenta") String no_cuenta) {
		String msg = "";
		if (this.cuentasService.delete(no_cuenta) != null) {
			msg = "Registro eliminado con RUT: " + no_cuenta;
		} else {
			msg = "No existe registro relacionado con RUT: " + no_cuenta;
		}
		return msg;
	}
}
