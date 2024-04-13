package com.etecja.deyaulas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etecja.deyaulas.Entities.Crianca;
public interface CriancaRepository extends JpaRepository<Crianca, Integer> {
    @Query("SELECT c FROM Crianca c WHERE c.email = :email")
    Crianca findByEmail(String email);
}
