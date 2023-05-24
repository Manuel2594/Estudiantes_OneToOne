package com.codingdojo.estudiantesuno.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.estudiantesuno.models.Contacto;
import com.codingdojo.estudiantesuno.models.Estudiante;
import com.codingdojo.estudiantesuno.services.MainServices;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	MainServices mainServices;
	
	@GetMapping("/")
	public String raiz(Model viewModel) {
		List<Estudiante> todos = mainServices.todosEstudiante();
		viewModel.addAttribute("todos",todos);
		return "index.jsp";
	}
	
	@GetMapping("/estudiante/new")
	public String formularioEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
		return"nuevoestudiante.jsp";
	}
	
	@PostMapping("/estudiante/new")
	public String crearEstudiante(@Valid @ModelAttribute("estudiante") Estudiante estudiante, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "redirect:/estudiante/new";
		}
		mainServices.crearEstudiante(estudiante);
		return "redirect:/";
	}
	
	
	@GetMapping("/contacto/new")
	public String formularioContacto(@ModelAttribute("contacto") Contacto contacto,
			Model viewModel) {
		List<Estudiante> todos = mainServices.obtenerNoLicenciadosJPA();
		viewModel.addAttribute("estudiantes",todos);
		return"nuevocontacto.jsp";
	}

	
	@PostMapping("/contacto/new")
	public String crearContacto(@Valid @ModelAttribute("contacto") Contacto contacto,
			BindingResult resultado,Model viewModel) {
		if (resultado.hasErrors()) {
			return "redirect:/contacto/new";
		}
		mainServices.crearContacto(contacto);
		return "redirect:/";
	}
	
	
	

}
