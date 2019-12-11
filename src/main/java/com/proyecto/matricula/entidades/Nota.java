package com.proyecto.matricula.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity
public class Nota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	private int nota1;
	@NotNull
	private int nota2;
	@NotNull
	private int nota3;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matriculaId")
    private Matricula matricula;

	public Nota(int id, int nota1, int nota2, int nota3, Matricula matricula) {
		this.id = id;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.matricula = matricula;
	}
	public Nota(int nota1, int nota2, int nota3, Matricula matricula) {
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.matricula = matricula;
	}
	public Nota() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNota1() {
		return nota1;
	}
	public void setNota1(int nota1) {
		this.nota1 = nota1;
	}
	public int getNota2() {
		return nota2;
	}
	public void setNota2(int nota2) {
		this.nota2 = nota2;
	}
	public int getNota3() {
		return nota3;
	}
	public void setNota3(int nota3) {
		this.nota3 = nota3;
	}
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
	
}
