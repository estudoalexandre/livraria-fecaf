package br.com.fecaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.fecaf.model.Livro;
import br.com.fecaf.repository.LivroRepository;
import br.com.fecaf.services.LivroService;
import jakarta.servlet.http.HttpServletRequest;

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


    @RequestMapping(value = "/cadastrarLivro", method = {RequestMethod.GET, RequestMethod.POST})
    public String cadastrarLivro(@ModelAttribute Livro livro, Model model, HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase("GET")) {
            // Requisição GET: retorna o formulário vazio para criação
            model.addAttribute("livro", new Livro()); // Cria um objeto vazio para o formulário
            return "cadastrar_livro"; // Nome do template Thymeleaf
        }

        // Requisição POST: salva o livro
        livroService.cadastrarLivro(livro);
        return "redirect:/livros/listarLivros";
    }

    
}
