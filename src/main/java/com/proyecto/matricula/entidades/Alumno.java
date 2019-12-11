package com.proyecto.matricula.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Column(name = "nombre_alumno")
	private String nombre;
	@NotEmpty
	@Column(name = "apellido_alumno")
	private String apellido;
	@NotNull
	private int edad;
	@NotEmpty
	private String sexo;
	@NotEmpty
	private String lugar;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "encargadoId")
    private Encargado encargado;

	public Alumno(int id, @NotEmpty String nombre, @NotEmpty String apellido, int edad, @NotEmpty String sexo,
			@NotEmpty String lugar, Encargado encargado) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.sexo = sexo;
		this.lugar = lugar;
		this.encargado = encargado;
	}

	public Alumno(@NotEmpty String nombre, @NotEmpty String apellido, int edad, @NotEmpty String sexo,
			@NotEmpty String lugar, Encargado encargado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.sexo = sexo;
		this.lugar = lugar;
		this.encargado = encargado;
	}

	public Alumno() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Encargado getEncargado() {
		return encargado;
	}

	public void setEncargado(Encargado encargado) {
		this.encargado = encargado;
	}
	
	
}
