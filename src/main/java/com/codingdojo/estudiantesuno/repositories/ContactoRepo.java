package com.codingdojo.estudiantesuno.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.estudiantesuno.models.Contacto;

public interface ContactoRepo extends CrudRepository<Contacto ,Long>  {
		public List<Contacto> findAll();
	}