package com.example.demo.repository.modelo;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "materia")
public class Materia {

	@Id
	@Column(name = "mate_id")
	@GeneratedValue(generator = "sec_materia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sec_materia", sequenceName = "sec_materia", allocationSize = 1)
	private Integer id;

	@Column(name = "mate_codigo")
	private String codigo;

	@Column(name = "mate_nombre")
	private String nombre;

	@Column(name = "mate_num_creditos")
	private Integer numCreditos;

	@Column(name = "mate_cedula_profesor")
	private String cedulaProfesor;

	@OneToMany(mappedBy = "materia")
	private List<Matricula> matricula;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumCreditos() {
		return numCreditos;
	}

	public void setNumCreditos(Integer numCreditos) {
		this.numCreditos = numCreditos;
	}

	public String getCedulaProfesor() {
		return cedulaProfesor;
	}

	public void setCedulaProfesor(String cedulaProfesor) {
		this.cedulaProfesor = cedulaProfesor;
	}

	public List<Matricula> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<Matricula> matricula) {
		this.matricula = matricula;
	}

}