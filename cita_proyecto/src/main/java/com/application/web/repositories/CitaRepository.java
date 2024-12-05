package com.application.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.web.models.Cita;

public interface CitaRepository extends JpaRepository<Cita, Integer>{
	//Encontrar citas por estado
    List<Cita> findByEstado(String estado);
    
    //Encontrar citas por ID de usuario
    List<Cita> findByCliente_Id(Integer id);
}
