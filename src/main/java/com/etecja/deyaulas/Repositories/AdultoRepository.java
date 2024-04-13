package com.etecja.deyaulas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etecja.deyaulas.Entities.Adulto;
public interface AdultoRepository extends JpaRepository<Adulto, Integer> {
    @Query("SELECT a FROM Adulto a WHERE a.email = :email")
    Adulto findByEmail(String email);
}
