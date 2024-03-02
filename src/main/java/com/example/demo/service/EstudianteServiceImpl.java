package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EstudianteRepositoryImp;
import com.example.demo.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private EstudianteRepositoryImp estudianteRepositoryImp;

	@Override
	public void registrarEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepositoryImp.insertar(estudiante);

	}

}