package com.application.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.application.web.models.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer>{

}
