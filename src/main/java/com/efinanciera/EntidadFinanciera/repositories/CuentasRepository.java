package com.efinanciera.EntidadFinanciera.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efinanciera.EntidadFinanciera.entities.Cuentas;

@Repository
public interface CuentasRepository extends JpaRepository<Cuentas, UUID>{

}
