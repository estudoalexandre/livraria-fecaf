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
            model.addAttribute("livro", new Livro()); 
            return "cadastrar_livro";
        }

        livroService.cadastrarLivro(livro);
        return "redirect:/livros/listarLivros";
    }

    @PostMapping("/deletar")
    public String deletarLivro(@RequestParam("id") Long id){
        livroService.excluirLivro(id);
        System.out.println("Livro deletado com sucesso" + id);
        return "redirect:/livros/listarLivros";
    }

    
}
