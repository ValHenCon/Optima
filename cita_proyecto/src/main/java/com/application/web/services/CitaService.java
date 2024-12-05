package com.application.web.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.web.models.Cita;
import com.application.web.models.Usuario;
import com.application.web.repositories.CitaRepository;

@Service
public class CitaService {
	@Autowired
    private CitaRepository citaRepository;

    public Cita createCita(Cita cita) {
        cita.setEstado("pendiente");
        return citaRepository.save(cita);
    }

    public List<Cita> getCitasPendientes() {
    	return citaRepository.findByEstado("pendiente");
    }

    public Cita asignarCita(int citaId, Usuario agente) {
        if (!"agente".equals(agente.getRol())) {
            throw new IllegalArgumentException("El usuario no es un agente");
        }
        Cita cita = citaRepository.findById(citaId).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        cita.setAgente(agente);
        cita.setFechaAsignacion(LocalDateTime.now());
        return citaRepository.save(cita);
    }

    public Cita completarCita(int citaId) {
        Cita cita = citaRepository.findById(citaId).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        cita.setEstado("completada");
        cita.setFechaCierre(LocalDateTime.now());
        return citaRepository.save(cita);
    }
    
    public List<Cita> getAllCitas() {
        return citaRepository.findAll(); 
    }
    
    public Cita reabrirCita(int citaId) {
        Optional<Cita> optionalCita = citaRepository.findById(citaId);

        if (optionalCita.isPresent()) {
            Cita cita = optionalCita.get();
            cita.setEstado("pendiente"); // Cambia según el estado "abierta" en tu lógica
            cita.setFechaCierre(null); // Elimina la fecha de cierre
            return citaRepository.save(cita); // Guarda los cambios
        } else {
        	throw new NoSuchElementException("Cita no encontrada con ID: " + citaId);
        }
    }
}
