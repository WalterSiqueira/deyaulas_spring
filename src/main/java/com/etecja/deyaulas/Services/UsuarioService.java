package com.etecja.deyaulas.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etecja.deyaulas.Entities.Usuario;
import com.etecja.deyaulas.Repositories.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository criancaRepository;

    public List<Usuario> findAll() {
        return criancaRepository.findAll();
    }
    public void save(Usuario crianca) {
		criancaRepository.save(crianca);
	}

    public Usuario verificarEmail(String email) {
        return criancaRepository.findByEmail(email);
    }
}
