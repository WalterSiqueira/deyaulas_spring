package com.etecja.deyaulas.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etecja.deyaulas.Entities.Crianca;
import com.etecja.deyaulas.Repositories.CriancaRepository;

@Service
public class CriancaService {
    @Autowired
    private CriancaRepository criancaRepository;

    public List<Crianca> findAll() {
        return criancaRepository.findAll();
    }
    public void save(Crianca crianca) {
		criancaRepository.save(crianca);
	}

    public Crianca verificarEmail(String email) {
        return criancaRepository.findByEmail(email);
    }
}
