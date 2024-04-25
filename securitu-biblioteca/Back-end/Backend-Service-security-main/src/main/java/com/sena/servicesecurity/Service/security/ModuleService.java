package com.sena.servicesecurity.Service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IModuleDto;
import com.sena.servicesecurity.Entity.Module;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.security.IModuleRepository;
import com.sena.servicesecurity.IService.security.IModuleService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class ModuleService extends ABaseService<Module> implements IModuleService{

	@Override
	protected IBaseRepository<Module, Long> getRepository() {
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Autowired
	private IModuleRepository repository;

	@Override
	public List<IModuleDto> getList() {
		return repository.getList();
	}	
}