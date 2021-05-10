package com.bruno.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.bookstore.domain.Categoria;
import com.bruno.bookstore.domain.Livro;
import com.bruno.bookstore.repositories.CategoriaRepository;
import com.bruno.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	LivroRepository livroRepository;

	public void instanciaBaseDeDados() {

		// instanciando categoria

		Categoria cat1 = new Categoria(null, "Informatica", "Livro DE TI");
		Categoria cat2 = new Categoria(null, "Ficção cientifica", "Ficção cientifica");
		Categoria cat3 = new Categoria(null, "Futebol", "Futebol");

		// instanciando Livro

		Livro l1 = new Livro(null, "Clean code ", "Robert Martins", "Loren ipsum", cat1);
		Livro l2 = new Livro(null, "Ficção ", "Robert ", "Loren ipsum", cat2);
		Livro l3 = new Livro(null, "Basket ", "Ronaldo", "Loren ipsum", cat3);
		Livro l4 = new Livro(null, "esporte ", "pabloe", "Loren ipsum", cat2);
		Livro l5 = new Livro(null, "volei ", "roberto", "Loren ipsum", cat2);

		// Fazenendo a categoria conhecer o seu livro e o livro conhecer sua categoria
		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4, l5));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
