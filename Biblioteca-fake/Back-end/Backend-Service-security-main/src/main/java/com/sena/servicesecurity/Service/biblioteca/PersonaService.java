package com.sena.servicesecurity.Service.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Persona;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.biblioteca.PersonaRepository;
import com.sena.servicesecurity.IService.biblioteca.IPersonaService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class PersonaService extends ABaseService<Persona> implements IPersonaService{

	@Override
	protected IBaseRepository<Persona, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private PersonaRepository repository;
}
