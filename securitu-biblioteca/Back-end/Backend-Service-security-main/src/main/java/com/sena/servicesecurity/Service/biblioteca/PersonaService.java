package com.sena.servicesecurity.Service.biblioteca;

import com.sena.servicesecurity.Entity.Persona;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.biblioteca.PersonaRepository;
import com.sena.servicesecurity.IService.biblioteca.IPersonaService;
import com.sena.servicesecurity.Service.ABaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService extends ABaseService<Persona> implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    protected IBaseRepository<Persona, Long> getRepository() {
        return personaRepository;
    }

    @Override
    public List<String> obtenerLibrosPorNombrePersona(String nombrePersona) {
        return personaRepository.findLibrosByNombrePersona(nombrePersona);
    }
}
