package com.etecja.deyaulas.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etecja.deyaulas.Entities.Fases;
public interface FasesRepository extends JpaRepository<Fases, Integer> {

    boolean existsById(Long id);

    void deleteById(Long id);

    Optional<Fases> findById(Long id);

}
