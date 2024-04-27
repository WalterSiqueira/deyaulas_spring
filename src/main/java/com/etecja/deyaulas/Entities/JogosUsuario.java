package com.etecja.deyaulas.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="jogosUsuario")
public class JogosUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario_id;

    @ManyToOne
    @JoinColumn(name= "jogos_id")
    private Jogos jogos_id;

    @OneToMany(mappedBy = "jogosUsuario_id")
    private List<FasesJogosUsuario> fasesJogosUsuario;

}
