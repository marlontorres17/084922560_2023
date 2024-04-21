package com.sena.servicesecurity.Entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="libro")
public class Libro extends ABaseEntity {

    @Column(name="titulo", length = 100, nullable = false)
    private String titulo;
    
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Persona persona;
    
    @Column(name="ano_publicacion")
    private Date anoPublicacion;
    
    @Column(name="genero", length = 50, nullable = false)
    private String genero;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Date getAnoPublicacion() {
		return anoPublicacion;
	}

	public void setAnoPublicacion(Date anoPublicacion) {
		this.anoPublicacion = anoPublicacion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
    
}
    
