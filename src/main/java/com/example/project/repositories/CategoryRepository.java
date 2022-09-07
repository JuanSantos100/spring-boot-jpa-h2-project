package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entities.Category;

/*
Interface de operações com o objeto Users
*/
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
