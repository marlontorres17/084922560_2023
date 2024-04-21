package com.sena.servicesecurity.Service.biblioteca;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Libro;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.biblioteca.ILibroRepository;
import com.sena.servicesecurity.IService.biblioteca.ILibroService;
import com.sena.servicesecurity.Service.ABaseService;
@Service
public class LibroService extends ABaseService<Libro> implements ILibroService{

	@Override
	protected IBaseRepository<Libro, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private ILibroRepository repository;

	 

		@Override
	    public Integer obtenerCantidadTotalDeLibros() {
	        return repository.getTotalLibrosDisponibles();
	       
	    }
	}


