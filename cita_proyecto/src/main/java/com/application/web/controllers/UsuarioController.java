package com.application.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.application.web.models.Usuario;
import com.application.web.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	 @Autowired
	 	public UsuarioService usuarioService;

	 @PostMapping
	 @CrossOrigin
	    public ResponseEntity<?> createUsuarios(@RequestBody Usuario usuario) {
	        if (usuario.getUsername() == null || usuario.getRol() == null) {
	            return new ResponseEntity<>("El nombre de usuario y el rol son obligatorios.", HttpStatus.BAD_REQUEST);
	        }
	        Usuario nuevoUsuario = usuarioService.createUsuario(usuario);
	        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
	    }

	    @GetMapping
	    @CrossOrigin
	    public ResponseEntity<List<Usuario>> getAllUsuarios() {
	        List<Usuario> usuarios = usuarioService.getAllUsuarios();
	        return new ResponseEntity<>(usuarios, HttpStatus.OK);
	    }
	    
	    @PostMapping("/login")
	    @CrossOrigin
	    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
	        Usuario usuarioAutenticado = usuarioService.autenticar(usuario.getUsername(), usuario.getPassword());
	        if (usuarioAutenticado != null) {
	            return new ResponseEntity<>(usuarioAutenticado, HttpStatus.OK);
	        }
	        return new ResponseEntity<>("Credenciales inválidas", HttpStatus.UNAUTHORIZED);
	    }
	    
	    
}
