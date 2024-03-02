package com.example.demo.repository.modelo;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "matricula")
public class Matricula {

	@Id
	@Column(name = "matr_id")
	@GeneratedValue(generator = "sec_matricula", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sec_matricula", sequenceName = "sec_matricula", allocationSize = 1)
	private Integer id;

	@Column(name = "matr_fecha")
	private LocalDate fecha;

	@Column(name = "matr_nombre_hilo")
	private String nombreHilo;

	@JoinColumn(name = "matr_id_estudiante")
	@ManyToOne(fetch = FetchType.EAGER)
	Estudiante estudiante;

	@JoinColumn(name = "matr_id_materia")
	@ManyToOne(fetch = FetchType.EAGER)
	Materia materia;
	
	//getters and setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getNombreHilo() {
		return nombreHilo;
	}

	public void setNombreHilo(String nombreHilo) {
		this.nombreHilo = nombreHilo;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fecha=" + fecha + ", nombreHilo=" + nombreHilo + ", estudiante=" + estudiante
				+ ", materia=" + materia + "]";
	}
	
	
}
