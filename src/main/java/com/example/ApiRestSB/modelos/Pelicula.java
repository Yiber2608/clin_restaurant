package com.example.ApiRestSB.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	Long id;
	
	
	String titulo;
	String director;
	String genero;
	
	
	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pelicula(String titulo, String director, String genero) {
		super();
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	
}
