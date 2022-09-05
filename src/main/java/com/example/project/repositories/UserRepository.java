package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entities.Users;

/*
Interface de operações com o objeto Users
*/
public interface UserRepository extends JpaRepository<Users, Long>{

}
