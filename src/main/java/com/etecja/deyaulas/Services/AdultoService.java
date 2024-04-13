package com.etecja.deyaulas.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etecja.deyaulas.Entities.Adulto;
import com.etecja.deyaulas.Repositories.AdultoRepository;

@Service
public class AdultoService {
    @Autowired
    private AdultoRepository adultoRepository;

    public List<Adulto> findAll() {
        return adultoRepository.findAll();
    }
    public void save(Adulto adulto) {
		adultoRepository.save(adulto);
	}

    public Adulto verificarEmail(String email) {
        return adultoRepository.findByEmail(email);
    }
}
