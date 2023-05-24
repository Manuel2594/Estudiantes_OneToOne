package com.codingdojo.estudiantesuno.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.estudiantesuno.models.Estudiante;

public interface EstudianteRepo extends CrudRepository<Estudiante ,Long>  {
		List<Estudiante> findAll();
		
		List<Estudiante> findByContactoIdIsNull();
	}