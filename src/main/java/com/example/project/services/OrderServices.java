package com.example.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entities.Order;
import com.example.project.repositories.OrderRepository;

@Service //Registro de componente da classe que sofrerá injecção de dependência
public class OrderServices {
	
	@Autowired //Spring faz a injeção de dependência de forma transparente ao programador
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional <Order> obj = repository.findById(id);
		return obj.get(); //Retorna um objeto do tipo Order
	}
}
