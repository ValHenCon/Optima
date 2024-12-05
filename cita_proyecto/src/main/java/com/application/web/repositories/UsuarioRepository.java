package com.application.web.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.web.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	//Encontrar un usuario por su id
    Usuario findById(int id);
    
    //Encontrar un usuario por su user y passwd
    Usuario findByUsernameAndPassword(String username, String password);
}	
