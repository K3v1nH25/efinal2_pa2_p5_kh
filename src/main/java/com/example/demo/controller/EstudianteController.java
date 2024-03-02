package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.service.EstudianteServiceImpl;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private EstudianteServiceImpl estudianteServiceImpl;

	@GetMapping(value = "/inicio")
	public String iniciar(Model modelo) {
		modelo.addAttribute("estudiante", new Estudiante());
		return "vistaEstudiantes";
	}

	@PostMapping(value = "/registrar")
	public String registrar(Estudiante estudiante) {
		estudianteServiceImpl.registrarEstudiante(estudiante);
		this.estudianteServiceImpl.registrarEstudiante(estudiante);
		return "redirect:/estudiantes/inicio";
	}

}
