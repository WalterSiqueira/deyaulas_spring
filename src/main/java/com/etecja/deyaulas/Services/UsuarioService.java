package com.etecja.deyaulas.Services;

import java.util.List;
import java.util.Optional;

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

    public boolean updateUsuario(Long id, Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);
    if (usuarioExistente.isPresent()) {
        Usuario u = usuarioExistente.get();
        u.setNome(usuario.getNome());
        u.setEmail(usuario.getEmail());
        // Adicione outras validações de campos conforme necessário

        try {
            usuarioRepository.save(u);
            return true;
        } catch (Exception e) {
            // Logar o erro ou lançar uma exceção específica, conforme necessário
            throw new RuntimeException("Erro ao atualizar o usuário com ID: " + id, e);
        }
        } else {
            return false;
        }
    }

    public boolean deleteUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
