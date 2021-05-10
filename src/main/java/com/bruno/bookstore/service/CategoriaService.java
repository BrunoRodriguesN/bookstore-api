package com.bruno.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.bruno.bookstore.domain.Categoria;
import com.bruno.bookstore.dtos.CategoriaDTO;
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
	
	public List<Categoria> findAll(){
		return repository.findAll();	
	}
	//Metodo create
	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	//Metodo update
	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}
	//Metodo delete
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new com.bruno.bookstore.service.exceptions.DataIntegrityViolationException(
			"Categoria nao pode ser deletado! Possui livros associados");
			
		}
		
		
	}

}
