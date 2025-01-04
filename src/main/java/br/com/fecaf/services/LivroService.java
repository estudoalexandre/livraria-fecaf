package br.com.fecaf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fecaf.model.Livro;
import br.com.fecaf.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;
    
    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }
    
}
