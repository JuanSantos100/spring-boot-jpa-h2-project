package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entities.Order;

/*
Interface de operações com o objeto Users
*/
public interface OrderRepository extends JpaRepository<Order, Long>{

}
