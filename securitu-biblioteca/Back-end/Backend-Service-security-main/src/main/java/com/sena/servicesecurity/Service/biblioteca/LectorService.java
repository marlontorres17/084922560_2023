package com.sena.servicesecurity.Service.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Lector;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.biblioteca.ILectorRepository;
import com.sena.servicesecurity.IService.biblioteca.ILectorService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class LectorService extends ABaseService<Lector> implements ILectorService{

	@Override
	protected IBaseRepository<Lector, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}

	@Autowired
	private ILectorRepository repository;
}
