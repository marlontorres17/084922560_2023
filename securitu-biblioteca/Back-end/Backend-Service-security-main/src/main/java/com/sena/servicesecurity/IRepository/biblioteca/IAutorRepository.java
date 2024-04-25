package com.sena.servicesecurity.IRepository.biblioteca;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Autor;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IAutorRepository extends IBaseRepository<Autor, Long>{

}
