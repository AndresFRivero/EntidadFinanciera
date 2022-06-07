package com.efinanciera.EntidadFinanciera.controllers;

import java.util.ArrayList;
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

import com.efinanciera.EntidadFinanciera.entities.Clientes;
import com.efinanciera.EntidadFinanciera.entities.Cuentas;
import com.efinanciera.EntidadFinanciera.service.ClientesService;
import com.efinanciera.EntidadFinanciera.service.CuentasService;

@RestController
@RequestMapping("/clientes")
public class ControllerClientes {

	@Autowired
	private ClientesService clientesService;

	@Autowired
	private CuentasService cuentasService;

	@GetMapping("/")
	public List<Clientes> getAll() {
		return this.clientesService.getAll();
	}

	@PostMapping("/create")
	public String create(@RequestBody Clientes cliente) {
		Clientes clRut = this.clientesService.getByRut(cliente.getRut());
		List<Cuentas> cuentas = new ArrayList<>();
		String msg = "";
		if (clRut == null) {
			for (Cuentas cu : this.cuentasService.getAll()) {
				for (Cuentas cu2 : cliente.getCuentas()) {
					if (cu.getNo_cuenta().equals(cu2.getNo_cuenta())) {
						cuentas.add(cu);
					}
				}
			}
			cliente.setCuentas(cuentas);
			this.clientesService.create(cliente);
			msg = "Cliente Registrado: \n";
		} else {
			msg = "No podemos registrar el cliente por RUT ya registrado";
		}

		return msg + cliente.toString();
	}

	@PutMapping("/update")
	public String update(@RequestBody Clientes cliente) {
		String msg = "";
		Clientes clRut = this.clientesService.getByRut(cliente.getRut());
		if (clRut != null) {
			clRut.setNombre(cliente.getNombre());
			clRut.setApellido(cliente.getApellido());
			clRut.setNo_documento(cliente.getNo_documento());
			clRut.setRazon_social(cliente.getRazon_social());
			clRut.setAnio_fundacion(cliente.getAnio_fundacion());
			this.clientesService.update(clRut);
			msg = "Cliente Actualizado con RUT: " + cliente.getRut();
		} else {
			msg = "No se cliente relacionado: \n";
		}
		return msg;
	}

	@GetMapping("/getByRut")
	public Clientes getByRut(@RequestParam("rut") String rut) {
		Clientes cl = null;
		if (this.clientesService.getByRut(rut) != null) {
			cl = this.clientesService.getByRut(rut);
		} else {
			System.out.println("No hay registro de: " + rut);
		}
		return cl;
	}

	@DeleteMapping("/deleteCliente")
	public String delete(@RequestParam("rut") String rut) {
		String msg = "";
		if (this.clientesService.delete(rut) != null) {
			msg = "Registro eliminado con RUT: " + rut;
		} else {
			msg = "No existe registro relacionado con RUT: " + rut;
		}
		return msg;
	}

}
