package com.bruno.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.bookstore.domain.Livro;

//informando que estamos criando uma interface repository
@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

}
