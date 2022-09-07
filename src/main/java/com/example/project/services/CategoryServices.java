package com.example.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entities.Category;
import com.example.project.repositories.CategoryRepository;

@Service //Registro de componente da classe que sofrerá injecção de dependência
public class CategoryServices {
	
	@Autowired //Spring faz a injeção de dependência de forma transparente ao programador
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional <Category> obj = repository.findById(id);
		return obj.get(); //Retorna um objeto do tipo Users
	}
}
