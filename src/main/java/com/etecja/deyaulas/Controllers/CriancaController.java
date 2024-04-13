package com.etecja.deyaulas.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.etecja.deyaulas.Entities.Crianca;
import com.etecja.deyaulas.Repositories.CriancaRepository;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/crianca")
public class CriancaController {
    @Autowired
    private CriancaRepository criancaRepository;

    @GetMapping("/cadastro")
    public String CadastroCrianca(Model model) {
        return "CadastroCrianca";
    }
    @PostMapping("/cadastrar")
    public String salvarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
        Crianca crianca = new Crianca();
        crianca.setNome(nome);
        crianca.setEmail(email);
        crianca.setSenha(senha);
        criancaRepository.save(crianca);
        return("redirect:/crianca/cadastro");
    }
}
