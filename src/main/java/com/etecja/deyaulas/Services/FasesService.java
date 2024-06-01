package com.etecja.deyaulas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etecja.deyaulas.Entities.Fases;
import com.etecja.deyaulas.Repositories.FasesRepository;

@Service
public class FasesService {
    @Autowired
    private FasesRepository fasesRepository;

    public List<Fases> findAll() {
        return fasesRepository.findAll();
    }
    public void save(Fases fases) {
		fasesRepository.save(fases);
	}

    public String registerUsuario(Fases fases) {
        fasesRepository.save(fases);
        return "Usuário registrado com sucesso.";
    }

    public boolean updateUsuario(Long id, Fases fases) {
        Optional<Fases> fasesExistente = fasesRepository.findById(id);
        if (fasesExistente.isPresent()) {
            Fases f = fasesExistente.get();
            f.setNome(fases.getNome());
            // Atualize outros campos conforme necessário
            fasesRepository.save(f);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteUsuario(Long id) {
        if (fasesRepository.existsById(id)) {
            fasesRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public boolean updateFases(Long id, Fases fases) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateFases'");
    }

}
