package com.etecja.deyaulas.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.etecja.deyaulas.Repositories.UsuarioRepository;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @SuppressWarnings("unused")
    @Autowired
    private UsuarioRepository UsuarioRepository;

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

}
