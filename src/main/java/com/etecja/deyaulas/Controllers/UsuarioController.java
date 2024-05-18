package com.etecja.deyaulas.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.etecja.deyaulas.Entities.Usuario;
import com.etecja.deyaulas.Repositories.UsuarioRepository;
import com.etecja.deyaulas.Services.UsuarioService;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @SuppressWarnings("unused")
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String CadastroUsuario(Model model) {
        return "CadastroUsuario";
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario, Model model) {
        if (usuarioService.emailExists(usuario.getEmail())) {
            return "redirect:/usuario/existente";
        } else {
            usuarioService.registerUsuario(usuario);
            return "redirect:/usuario/successo";
        }
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
