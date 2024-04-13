package com.sena.formula.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "piloto")
public class Piloto extends ABaseEntity {
    
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;
    
    @Column(name = "apellido", length = 50, nullable = false)
    private String apellido;
    
    @Column(name = "apodo", length = 50, nullable = false, unique = true)
    private String apodo;
    
    @Column(name = "escuderia", length = 50, nullable = false)
    private String escuderia;
    
    @Column(name = "numero", length = 3, nullable = false)
    private Integer numero;

    @Column(name = "nacionalidad", length = 50, nullable = false)
    private String nacionalidad;


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

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    
	   
}