package com.lombokusuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lombokusuario.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
