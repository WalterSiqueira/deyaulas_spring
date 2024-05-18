package com.etecja.deyaulas.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etecja.deyaulas.Entities.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String Email);

}
