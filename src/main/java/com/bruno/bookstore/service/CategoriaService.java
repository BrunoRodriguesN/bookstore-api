package com.bruno.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.bookstore.domain.Categoria;
import com.bruno.bookstore.repositories.CategoriaRepository;
import com.bruno.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria findById(Integer id) {
		java.util.Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado! id: "
				+ id  + ", Tipo " + Categoria.class.getName()));
	}

}
