package com.sena.servicesecurity.Service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IRoleDto;
import com.sena.servicesecurity.Entity.Role;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.security.IRoleRepository;
import com.sena.servicesecurity.IService.security.IRoleService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class RoleService extends ABaseService<Role> implements IRoleService{

	@Override
	protected IBaseRepository<Role, Long> getRepository() {
		return repository;
	}
	
	@Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
	
	@Autowired
	private IRoleRepository repository;

	@Override
	public List<IRoleDto> getList() {
		return repository.getList();
	}	
}
