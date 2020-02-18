package com.danielhs.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielhs.cursomc.domain.Categoria;
import com.danielhs.cursomc.repositories.CategoriaRepository;

//@Service 
@Service
public class CategoriaService {

	//Automaticamente é instanciada pelo Spring, pelo mecanismo de independencia
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElse(null);
	}
	
}
