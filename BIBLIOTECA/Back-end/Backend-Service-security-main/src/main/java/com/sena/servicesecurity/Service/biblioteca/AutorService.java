package com.sena.servicesecurity.Service.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Autor;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.biblioteca.IAutorRepository;
import com.sena.servicesecurity.IService.biblioteca.IAutorService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class AutorService extends ABaseService<Autor> implements IAutorService{

	@Override
	protected IBaseRepository<Autor, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private IAutorRepository repository;

}
