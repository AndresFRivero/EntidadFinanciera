package com.efinanciera.EntidadFinanciera.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.efinanciera.EntidadFinanciera.entities.Movimientos;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimientos, UUID>{

}
