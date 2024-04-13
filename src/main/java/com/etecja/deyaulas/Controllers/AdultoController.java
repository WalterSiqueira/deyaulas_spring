package com.etecja.deyaulas.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.etecja.deyaulas.Entities.Adulto;
import com.etecja.deyaulas.Repositories.AdultoRepository;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/adulto")
public class AdultoController {
    @Autowired
    private AdultoRepository adultoRepository;

    @GetMapping("/cadastro")
    public String CadastroCrianca(Model model) {
        return "CadastroAdulto";
    }

    @PostMapping("/cadastrar")
    public String salvarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
        Adulto adulto = new Adulto();
        adulto.setNome(nome);
        adulto.setEmail(email);
        adulto.setSenha(senha);
        adultoRepository.save(adulto);
        return("redirect:/adulto/cadastro");
    }
    
}
