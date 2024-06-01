package com.etecja.deyaulas.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etecja.deyaulas.Entities.Fases;
import com.etecja.deyaulas.Repositories.FasesRepository;
import com.etecja.deyaulas.Services.FasesService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/fases")
public class FasesController {
    @SuppressWarnings("unused")
    @Autowired
    private FasesRepository fasesRepository;

    @Autowired
    private FasesService fasesService;

    @PostMapping("/cadastrar")
    public String cadastrarFase(@ModelAttribute Fases fases, Model model) {
        return "replace this later!";
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
        List<Fases> fases = fasesService.findAll();
        model.addAttribute("fases", fases);
        return "listaUsuarios";
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody Fases fases) {
        try {
            boolean atualizado = fasesService.updateFases(id, fases);
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
            boolean deletado = fasesService.deleteUsuario(id);
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
