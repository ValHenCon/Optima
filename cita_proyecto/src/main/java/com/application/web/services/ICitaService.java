package com.application.web.services;

import java.util.List;

import com.application.web.models.Cita;
import com.application.web.models.Usuario;

public interface ICitaService {
	Cita createCita(Cita cita);
    List<Cita> getCitasPendientes();
    Cita asignarCita(int id, Usuario agente);
    Cita completarCita(int id);
}
