package com.lombokusuario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.lombokusuario.entities.Usuario;
import com.lombokusuario.repository.UsuarioRepository;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> buscaTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscaUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public Usuario salvaUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario alterarUsuario(Long id, Usuario alterarUsuario) {
        Optional<Usuario> existeUsuario = usuarioRepository.findById(id);
        if (existeUsuario.isPresent()) {
        	alterarUsuario.setId(id);
            return usuarioRepository.save(alterarUsuario);
        }
        return null;
   }

    public boolean apagarUsuario(Long codigo) {
        Optional<Usuario> existeUsuario = usuarioRepository.findById(codigo);
        if (existeUsuario.isPresent()) {
            usuarioRepository.deleteById(codigo);
            return true;
        }
        return false;
    }
}
