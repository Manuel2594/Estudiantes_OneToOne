package com.codingdojo.estudiantesuno.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.estudiantesuno.models.Contacto;
import com.codingdojo.estudiantesuno.models.Estudiante;
import com.codingdojo.estudiantesuno.repositories.ContactoRepo;
import com.codingdojo.estudiantesuno.repositories.EstudianteRepo;

@Service
public class MainServices {
	@Autowired
	private EstudianteRepo estudianterepo;
	@Autowired
	private ContactoRepo contactorepo;

	// CRUD Estudiante
	// CREAR
	public Estudiante crearEstudiante(Estudiante estudiante) {
		return estudianterepo.save(estudiante);
	}

	// LEER POR ID
	public Estudiante getEstudiante(Long id) {
		return estudianterepo.findById(id).orElse(null);
	}

	// LEER TODOS
	public List<Estudiante> todosEstudiante() {
		return estudianterepo.findAll();
	}

	// CRUD Contacto
	// CREAR
	public Contacto crearContacto(Contacto contacto) {
		return contactorepo.save(contacto);
	}

	// LEER POR ID
	public Contacto getContacto(Long id) {
		return contactorepo.findById(id).orElse(null);
	}

	// LEER TODOS
	public List<Contacto> todosContacto() {
		return contactorepo.findAll();
	}
	
	public List<Estudiante> obtenerNoLicenciadosJPA(){
		return estudianterepo.findByContactoIdIsNull();
	}
}
