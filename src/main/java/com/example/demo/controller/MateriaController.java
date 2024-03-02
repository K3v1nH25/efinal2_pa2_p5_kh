package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.service.EstudianteServiceImpl;
import com.example.demo.service.MateriaServiceImpl;

@Controller
@RequestMapping("/materias")
public class MateriaController {

	@Autowired
	private MateriaServiceImpl materiaServiceImpl;

	@GetMapping(value = "/inicio")
	public String iniciar(Model modelo) {
		modelo.addAttribute("materia", new Materia());
		return "vistaMaterias";
	}

	@PostMapping(value = "/registrar")
	public String registrar(Materia materia) {
		materiaServiceImpl.registrarMateria(materia);
		this.materiaServiceImpl.registrarMateria(materia);
		return "redirect:/materias/inicio";
	}

}
