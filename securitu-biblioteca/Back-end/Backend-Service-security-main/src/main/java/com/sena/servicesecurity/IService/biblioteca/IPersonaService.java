package com.sena.servicesecurity.IService.biblioteca;

import com.sena.servicesecurity.Entity.Persona;
import com.sena.servicesecurity.IService.IBaseService;

import java.util.List;

public interface IPersonaService extends IBaseService<Persona> {
    List<String> obtenerLibrosPorNombrePersona(String nombrePersona);
}
