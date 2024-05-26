package com.etecja.deyaulas.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.etecja.deyaulas.Entities.Usuario;
import com.etecja.deyaulas.Repositories.UsuarioRepository;
import com.etecja.deyaulas.Services.UsuarioService;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/todos")
    public String listarTodosUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "listaUsuarios";
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            boolean atualizado = usuarioService.updateUsuario(id, usuario);
            if (atualizado) {
                return new ResponseEntity<>("Usuário atualizado com sucesso!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Usuário não encontrado!", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar o usuário!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
        try {
            boolean deletado = usuarioService.deleteUsuario(id);
            if (deletado) {
                return new ResponseEntity<>("Usuário deletado com sucesso!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Usuário não encontrado!", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar o usuário!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
