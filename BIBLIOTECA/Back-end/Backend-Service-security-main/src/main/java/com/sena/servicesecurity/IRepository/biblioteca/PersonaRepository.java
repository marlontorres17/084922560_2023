package com.sena.servicesecurity.IRepository.biblioteca;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Persona;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface PersonaRepository extends IBaseRepository<Persona, Long>{

}
