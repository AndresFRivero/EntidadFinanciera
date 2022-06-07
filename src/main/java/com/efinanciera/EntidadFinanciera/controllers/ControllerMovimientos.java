package com.efinanciera.EntidadFinanciera.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.efinanciera.EntidadFinanciera.entities.Cuentas;
import com.efinanciera.EntidadFinanciera.entities.Movimientos;
import com.efinanciera.EntidadFinanciera.service.CuentasService;
import com.efinanciera.EntidadFinanciera.service.MovimientosService;

@RestController
@RequestMapping("/movimientos")
public class ControllerMovimientos {

	@Autowired
	private MovimientosService movimientosService;

	@Autowired
	private CuentasService cuentasService;

	@GetMapping("/")
	public List<Movimientos> getAll() {
		return this.movimientosService.getAll();
	}

	@PostMapping("/create")
	public String create(@RequestBody Movimientos movimientos) {
		String msg = "";
		String no_cuenta = movimientos.getCuenta().getNo_cuenta();
		Cuentas cuenta = this.cuentasService.getByNoCuenta(no_cuenta);
		if (cuenta != null) {
			Float sumaSaldo = (cuenta.getSaldo() + movimientos.getValor());
			if ((sumaSaldo <= 1000000 && cuenta.getTipo_moneda().getId() == 1)
					|| (sumaSaldo <= 300 && cuenta.getTipo_moneda().getId() == 2)
					|| (sumaSaldo <= 150 && cuenta.getTipo_moneda().getId() == 3)) {
				if (movimientos.getDescripcion() == 1) {
					cuenta.setSaldo(cuenta.getSaldo() + movimientos.getValor());
				} else {
					cuenta.setSaldo(cuenta.getSaldo() - movimientos.getValor());
				}
				movimientos.setCuenta(cuenta);
				this.cuentasService.update(cuenta);
				this.movimientosService.create(movimientos);
				msg = "Movimiento Registrado";
			}else {
				msg = "Movimiento rechazado";
			}
		} else {
			msg = "No fue posible hacer el movimiento la cuenta no EXISTE";
		}
		return msg;
	}

}
