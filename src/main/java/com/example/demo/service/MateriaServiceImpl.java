package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.MateriaRepositoryImpl;
import com.example.demo.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService {

	@Autowired
	private MateriaRepositoryImpl materiaRepositoryImpl;

	@Override
	public void registrarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepositoryImpl.insertar(materia);

	}

}
