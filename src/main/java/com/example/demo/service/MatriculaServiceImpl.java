package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IEstudianteRepository;
import com.example.demo.repository.IMateriaRepository;
import com.example.demo.repository.IMatriculaRepository;
import com.example.demo.repository.modelo.Estudiante;
import com.example.demo.repository.modelo.Materia;
import com.example.demo.repository.modelo.Matricula;
import com.example.demo.repository.modelo.dto.MatriculaDTO;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Autowired
	private IMatriculaRepository iMatriculaRepository;

	@Override
	public void matricularEstudiante(MatriculaDTO matriculaDTO) {
		// TODO Auto-generated method stub
		Estudiante estudiante = estudianteRepository.buscarEstudiantePorCedula(matriculaDTO.getCedulaEstudiante());
		List<Materia> materias = new ArrayList<>();
		materias.add(iMateriaRepository.buscarPorCodigo(matriculaDTO.getCodigoMateriaUno()));
		materias.add(iMateriaRepository.buscarPorCodigo(matriculaDTO.getCodigoMateriaDos()));
		materias.add(iMateriaRepository.buscarPorCodigo(matriculaDTO.getCodigoMateriaTres()));
		materias.add(iMateriaRepository.buscarPorCodigo(matriculaDTO.getCodigoMateriaCuatro()));

		List<Matricula> matriculas = new ArrayList<>();

		materias.parallelStream().forEach(materia -> {
			Matricula matricula = new Matricula();
			matricula.setFecha(LocalDate.now());
			matricula.setMateria(materia);
			matricula.setEstudiante(estudiante);
			matricula.setNombreHilo(Thread.currentThread().getName());
			
			iMatriculaRepository.insertar(matricula);
		});

	}

}
