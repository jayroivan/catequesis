package com.proyecto.matricula.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date nombre;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumnoid")
    private Alumno alumno;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grupoId")
    private Grupo grupo;

	public Matricula(int id, @NotEmpty Date nombre, Alumno alumno, Grupo grupo) {
		this.id = id;
		this.nombre = nombre;
		this.alumno = alumno;
		this.grupo = grupo;
	}

	public Matricula(@NotEmpty Date nombre, Alumno alumno, Grupo grupo) {
		this.nombre = nombre;
		this.alumno = alumno;
		this.grupo = grupo;
	}

	public Matricula() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getNombre() {
		return nombre;
	}

	public void setNombre(Date nombre) {
		this.nombre = nombre;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	
	
}
