package com.sena.servicesecurity.Service.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Registro;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.biblioteca.IRegistroRepository;
import com.sena.servicesecurity.IService.biblioteca.IRegistroService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class RegistroService extends ABaseService<Registro> implements IRegistroService{

	@Override
	protected IBaseRepository<Registro, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private IRegistroRepository repository;
}
