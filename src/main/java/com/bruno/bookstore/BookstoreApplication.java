package com.bruno.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bruno.bookstore.domain.Categoria;
import com.bruno.bookstore.domain.Livro;
import com.bruno.bookstore.repositories.CategoriaRepository;
import com.bruno.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//instanciando categoria
		
		Categoria cat1 = new  Categoria(null, "Informatica", "Livro DE TI");
		

		//instanciando Livro
		
		Livro l1 = new Livro(null, "Clean code ", "Robert Martins","Loren ipsum", cat1);
		
		//Fazenendo a categoria conhecer o seu livro e o livro conhecer sua categoria
		cat1.getLivros().addAll(Arrays.asList(l1));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1));
		
	}

}
