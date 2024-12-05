package com.application.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.application.web.models.Cita;

public interface ICitaDao extends JpaRepository<Cita, Integer>{

}
