package com.application.web.services;

import java.util.List;

import com.application.web.models.Usuario;

public interface IUsuarioService {
	Usuario createUsuario(Usuario usuario);
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(int id);
}
