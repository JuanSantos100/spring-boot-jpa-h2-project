package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entities.OrderItem;

/*
Interface de operações com o objeto OrderItem
*/
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}