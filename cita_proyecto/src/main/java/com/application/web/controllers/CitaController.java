package com.application.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.web.models.Cita;
import com.application.web.models.Usuario;
import com.application.web.services.CitaService;

@RestController
@RequestMapping("/api/citas")
public class CitaController {
	@Autowired
    public CitaService citaService;

    @PostMapping("/añadir")
    @CrossOrigin
    public ResponseEntity<Cita> createCita(@RequestBody Cita cita) {
        Cita nuevaCita = citaService.createCita(cita);
        return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
    }
    
    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<Cita>> getAllCitas() {
        List<Cita> citas = citaService.getAllCitas();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @GetMapping("/pendientes")
    @CrossOrigin
    public ResponseEntity<List<Cita>> getCitasPendientes() {
        List<Cita> citasPendientes = citaService.getCitasPendientes();
        return new ResponseEntity<>(citasPendientes, HttpStatus.OK);
    }

    @PostMapping("/{citaId}/asignar")
    @CrossOrigin
    public ResponseEntity<Cita> asignarCita(@PathVariable int citaId, @RequestBody Usuario agente) {
        Cita citaAsignada = citaService.asignarCita(citaId, agente);
        return new ResponseEntity<>(citaAsignada, HttpStatus.OK);
    }

    @PostMapping("/{citaId}/completar")
    @CrossOrigin
    public ResponseEntity<Cita> completarCita(@PathVariable int citaId) {
        Cita citaCompletada = citaService.completarCita(citaId);
        return new ResponseEntity<>(citaCompletada, HttpStatus.OK);
    }
    
    @PostMapping("/{citaId}/reabrir")
    @CrossOrigin
    public ResponseEntity<Cita> reabrirCita(@PathVariable int citaId) {
        Cita citaReabierta = citaService.reabrirCita(citaId);
        return new ResponseEntity<>(citaReabierta, HttpStatus.OK);
    }
}
