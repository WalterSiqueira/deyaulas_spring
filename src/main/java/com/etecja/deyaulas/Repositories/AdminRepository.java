package com.etecja.deyaulas.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etecja.deyaulas.Entities.Administradores;
public interface AdminRepository extends JpaRepository<Administradores, Integer> {

}
