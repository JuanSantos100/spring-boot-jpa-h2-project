package com.example.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.project.entities.Users;
import com.example.project.repositories.UserRepository;
import com.example.project.services.exceptions.DatabaseException;
import com.example.project.services.exceptions.ResourceNotFoundException;

@Service //Registro de componente da classe que sofrerá injecção de dependência
public class UserServices {
	
	@Autowired //Spring faz a injeção de dependência de forma transparente ao programador
	private UserRepository repository;
	
	public List<Users> findAll() {
		return repository.findAll();
	}
	
	public Users findById(Long id) {
		Optional <Users> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Users insert(Users obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Users update(Long id, Users obj) {
		/*
		 * O método getOne não vai até o banco para consultar um usuário e trazer o objeto
		 * ele simplelesmente prepara o objeto monitorado pelo JPA para depois realizar operações com o banco
		 * . Sendo mais eficiente
		 */
		
		Users entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		
		
		
	}

	private void updateData(Users entity, Users obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
