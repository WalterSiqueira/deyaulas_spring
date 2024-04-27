package com.etecja.deyaulas.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fasesJogosUsuario")
public class FasesJogosUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double highscore;
    private char finalizada;
    private char disponivel;

    @ManyToOne
    @JoinColumn(name = "jogosUsuario_id")
    private JogosUsuario jogosUsuario_id;

    @ManyToOne
    @JoinColumn(name = "fases_id")
    private Fases fases_id;

}
