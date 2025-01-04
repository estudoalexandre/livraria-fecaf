package br.com.fecaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fecaf.model.Livro;
import br.com.fecaf.repository.LivroRepository;
import br.com.fecaf.services.LivroService;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;
    @Autowired
    private LivroRepository livroRepository;
    
    // @GetMapping("/listarLivros")
    // @ResponseBody
    // public List<Livro> listarLivros() {
        //     return livroService.listarLivros();
        // }
        
    @CrossOrigin(origins = "http://localhost:5500", allowedHeaders = "*")
    @GetMapping("/listarLivros")
    public String listarLivros(Model model) {
        model.addAttribute("livros", livroService.listarLivros());
        return "livros_cadastrados";
    }

    
}
