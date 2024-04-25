package com.sena.servicesecurity.IRepository.biblioteca;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Libro;
import com.sena.servicesecurity.IRepository.IBaseRepository;


@Repository
public interface ILibroRepository extends IBaseRepository<Libro, Long>{

	
	
	@Query(value = "SELECT COUNT(*) AS totalLibros FROM libro", nativeQuery = true)
    Integer getTotalLibrosDisponibles();
	
}
