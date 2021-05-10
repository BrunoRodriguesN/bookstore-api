package com.bruno.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruno.bookstore.domain.Categoria;

//informando que estamos criando uma interface repository
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

	
}
