package com.proyecto.matricula.entidades;

import javax.persistence.Column;
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
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Column(name = "nombre_grupo")
	private String nombre;
	@NotEmpty
	private String descripcion;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catequistaid")
    private Catequista catequista;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nivelId")
    private Nivel nivel;

	public Grupo(int id, @NotEmpty String nombre, @NotEmpty String descripcion, Catequista catequista, Nivel nivel) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.catequista = catequista;
		this.nivel = nivel;
	}

	public Grupo(@NotEmpty String nombre, @NotEmpty String descripcion, Catequista catequista, Nivel nivel) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.catequista = catequista;
		this.nivel = nivel;
	}
	
	public Grupo() {
		
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Catequista getCatequista() {
		return catequista;
	}

	public void setCatequista(Catequista catequista) {
		this.catequista = catequista;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	
}
