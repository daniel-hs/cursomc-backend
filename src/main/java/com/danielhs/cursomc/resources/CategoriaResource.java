package com.danielhs.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielhs.cursomc.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	List<Categoria> categorias = new ArrayList<>();
	
	@GetMapping
	public List<Categoria> listarCategorias() {
		return categorias;
	}
	
	@PostMapping
	public void salvarCategoria(@RequestBody Categoria categoria) {
		System.out.println(categoria);
		categorias.add(categoria);
	}
	
	@PutMapping(value="/{id}")
	public void alterarCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
		categorias.get(categoria.getId() - 1).setNome(categoria.getNome());;
		
	}
	
	@DeleteMapping(value="/{id}")
	public void excluirCategoria(@PathVariable Integer id) {
		System.out.println(categorias.get(id));
		categorias.remove(id);
	}
	
	

}
