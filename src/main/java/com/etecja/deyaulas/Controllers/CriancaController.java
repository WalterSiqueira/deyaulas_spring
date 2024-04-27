package com.etecja.deyaulas.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.etecja.deyaulas.Entities.Usuario;
import com.etecja.deyaulas.Repositories.UsuarioRepository;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/usuario")
public class CriancaController {
    @Autowired
    private UsuarioRepository criancaRepository;

    @GetMapping("/cadastro")
    public String CadastroUsuario(Model model) {
        return "CadastroUsuario";
    }

    @GetMapping("/successo")
    public String successo() {
        return "successo";
    }

    @GetMapping("/existente")
    public String existente() {
        return "existente";
    }

    @PostMapping("/cadastrar")
    public String salvarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
        Usuario crianca = new Usuario();
        Usuario criancaExistente = criancaRepository.findByEmail(email);
        if (criancaExistente != null) {
            return "redirect:/usuario/existente";
        } else {
            crianca.setNome(nome);
            crianca.setEmail(email);
            crianca.setSenha(senha);
            criancaRepository.save(crianca);
            return("redirect:/usuario/successo");
        }
    }
}
