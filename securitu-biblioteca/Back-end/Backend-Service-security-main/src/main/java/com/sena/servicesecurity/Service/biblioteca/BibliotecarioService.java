package com.sena.servicesecurity.Service.biblioteca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Bibliotecario;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.biblioteca.IBibliotecarioRepository;
import com.sena.servicesecurity.IService.biblioteca.IBibliotecarioService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class BibliotecarioService extends ABaseService<Bibliotecario> implements IBibliotecarioService{

	@Override
	protected IBaseRepository<Bibliotecario, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}

	@Autowired
	private IBibliotecarioRepository repository;
}
