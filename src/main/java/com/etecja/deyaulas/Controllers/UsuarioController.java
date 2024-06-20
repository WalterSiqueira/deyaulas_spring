package com.etecja.deyaulas.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.etecja.deyaulas.Entities.Usuario;
import com.etecja.deyaulas.Services.UsuarioService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

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
            return "redirect:/usuario/sucesso";
        }
    }

    @GetMapping("/sucesso")
    public String sucesso() {
        return "sucesso";
    }

    @GetMapping("/existente")
    public String existente() {
        return "existente";
    }

    @GetMapping("/atualizado")
    public String usuarioAtualizado(Model model) {
        model.addAttribute("message", "Usuário atualizado com sucesso!");
        return "resultado";
    }

    @GetMapping("/nao_encontrado")
    public String usuarioNaoEncontrado(Model model) {
        model.addAttribute("message", "Usuário não encontrado!");
        return "resultado";
    }

    @GetMapping("/todos")
    public String listarTodosUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);
        return "listaUsuarios";
    }

    @PostMapping("/atualizar")
    public String atualizarUsuario(@ModelAttribute Usuario usuario, Model model) {
        Usuario usuarioExistente = usuarioService.findById(usuario.getId());
        if (usuarioExistente != null) {
            usuarioExistente.setNome(usuario.getNome());
            usuarioExistente.setSenha(usuario.getSenha());
            usuarioService.updateUsuario(usuarioExistente);
            return "redirect:/usuario/atualizado";
        } else {
            return "redirect:/usuario/nao_encontrado";
        }
    }

    @GetMapping("/atualizar/{id}")
    public String mostrarFormularioAtualizacao(@PathVariable("id") Long id, Model model) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario != null) {
            model.addAttribute("usuario", usuario);
            return "updateUsuario";
        } else {
            return "redirect:/usuario/nao_encontrado";
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
