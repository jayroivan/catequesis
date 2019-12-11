package com.proyecto.matricula.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Nivel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Column(name = "nombre_nivel")
	private String nombre;
	
	public Nivel(int id, @NotEmpty String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	public Nivel(@NotEmpty String nombre) {
		this.nombre = nombre;
	}
	public Nivel() {

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
	
	
}
