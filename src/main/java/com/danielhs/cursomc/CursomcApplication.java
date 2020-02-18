package com.danielhs.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.danielhs.cursomc.domain.Categoria;
import com.danielhs.cursomc.domain.Cidade;
import com.danielhs.cursomc.domain.Estado;
import com.danielhs.cursomc.domain.Produto;
import com.danielhs.cursomc.repositories.CategoriaRepository;
import com.danielhs.cursomc.repositories.CidadeRepository;
import com.danielhs.cursomc.repositories.EstadoRepository;
import com.danielhs.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Categoria - Produto
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		//relacionando
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		//Estado - Cidade
		Estado est1 = new Estado(null, "Paraná");
		Estado est2 = new Estado(null, "São Paulo");
		Cidade c1 = new Cidade(null, "Londrina", est1);
		Cidade c2 = new Cidade(null, "Curitiba", est1);
		Cidade c3 = new Cidade(null, "Assis", est2);
		Cidade c4 = new Cidade(null, "Botucatu", est2);
		est1.getCidades().addAll(Arrays.asList(c1, c2));
		est2.getCidades().addAll(Arrays.asList(c3, c4));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		
		
	}

}
