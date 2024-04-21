package com.sena.servicesecurity.IService.biblioteca;

import java.util.List;

import com.sena.servicesecurity.DTO.ILibroDto;
import com.sena.servicesecurity.Entity.Libro;
import com.sena.servicesecurity.IService.IBaseService;

public interface ILibroService extends IBaseService<Libro>{
	

public Integer obtenerCantidadTotalDeLibros();
}
