package com.danielhs.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielhs.cursomc.domain.Cliente;
import com.danielhs.cursomc.exceptions.ObjectNotFoundException;
import com.danielhs.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

	//Automaticamente é instanciada pelo Spring, pelo mecanismo de independencia
	@Autowired
	private ClienteRepository repository;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
}
