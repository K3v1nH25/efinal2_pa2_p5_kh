package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.repository.modelo.dto.MatriculaDTO;
import com.example.demo.service.MatriculaServiceImpl;

@Controller
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private MatriculaServiceImpl matriculaServiceImpl;

	@GetMapping(value = "/inicio")
	public String iniciar(Model modelo) {
		modelo.addAttribute("matriculaDTO", new MatriculaDTO());
		return "vistaMatriculas";
	}

	@PostMapping(value = "/matricular")
	public String registrar(MatriculaDTO matriculaDTO) {
		this.matriculaServiceImpl.matricularEstudiante(matriculaDTO);
		return "redirect:/matriculas/inicio";
	}

}
