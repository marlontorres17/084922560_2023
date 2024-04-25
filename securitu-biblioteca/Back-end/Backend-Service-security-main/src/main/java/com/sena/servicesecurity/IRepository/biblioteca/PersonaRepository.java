package com.sena.servicesecurity.IRepository.biblioteca;

import com.sena.servicesecurity.Entity.Persona;
import com.sena.servicesecurity.IRepository.IBaseRepository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface PersonaRepository extends IBaseRepository<Persona, Long> {

    @Query("SELECT lb.titulo FROM Registro rg INNER JOIN Libro lb ON rg.libro.id = lb.id INNER JOIN Persona ps ON rg.persona.id = ps.id WHERE ps.nombre = ?1")
    List<String> findLibrosByNombrePersona(String nombrePersona);
}
