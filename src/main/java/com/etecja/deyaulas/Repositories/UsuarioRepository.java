package com.etecja.deyaulas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.etecja.deyaulas.Entities.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT c FROM Crianca c WHERE c.email = :email")
    Usuario findByEmail(String email);
}
