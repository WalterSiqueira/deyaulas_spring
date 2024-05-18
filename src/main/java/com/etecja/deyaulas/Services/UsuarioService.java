package com.etecja.deyaulas.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etecja.deyaulas.Entities.Usuario;
import com.etecja.deyaulas.Repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

    public boolean emailExists(String email) {
        return usuarioRepository.findByEmail(email).isPresent();
    }

    public String registerUsuario(Usuario usuario) {
        if (emailExists(usuario.getEmail())) {
            return "Email já está em uso.";
        }
        usuarioRepository.save(usuario);
        return "Usuário registrado com sucesso.";
    }

}
