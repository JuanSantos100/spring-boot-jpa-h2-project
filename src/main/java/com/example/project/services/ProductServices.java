package com.example.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entities.Product;
import com.example.project.repositories.ProductRepository;

@Service //Registro de componente da classe que sofrerá injecção de dependência
public class ProductServices {
	
	@Autowired //Spring faz a injeção de dependência de forma transparente ao programador
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional <Product> obj = repository.findById(id);
		return obj.get(); //Retorna um objeto do tipo Product
	}
}
