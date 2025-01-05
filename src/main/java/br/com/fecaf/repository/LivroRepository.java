package br.com.fecaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fecaf.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}
