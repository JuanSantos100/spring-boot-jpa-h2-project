package com.example.project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.entities.Order;
import com.example.project.services.OrderServices;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderServices service;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List <Order> listaUsuarios = service.findAll();
		return ResponseEntity.ok().body(listaUsuarios);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
