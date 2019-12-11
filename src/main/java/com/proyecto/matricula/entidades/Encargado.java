package com.proyecto.matricula.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Encargado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Column(name = "nombre_encargado")
	private String nombre;
	@NotEmpty
	@Column(name = "apellido_encargado")
	private String apellido;
	@NotEmpty
	private String telefono;
	@NotEmpty
	private String parentesco;
	
	public Encargado(int id, @NotEmpty String nombre, @NotEmpty String apellido, @NotEmpty String telefono,
			@NotEmpty String parentesco) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.parentesco = parentesco;
	}
	public Encargado(@NotEmpty String nombre, @NotEmpty String apellido, @NotEmpty String telefono,
			@NotEmpty String parentesco) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.parentesco = parentesco;
	}
	public Encargado() {
		
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
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	
	
}
