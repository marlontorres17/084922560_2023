package com.sena.servicesecurity.Service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IDepartmentDto;
import com.sena.servicesecurity.Entity.Department;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.security.IDepartmentRepository;
import com.sena.servicesecurity.IService.security.IDepartmentService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class DepartmentService  extends ABaseService<Department> implements IDepartmentService{

	
	@Autowired
	public IDepartmentRepository repository;

	@Override
	public List<IDepartmentDto> getListDepartaments() {
		// TODO Auto-generated method stub
		return repository.getListDepartaments();
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}

	@Override
	protected IBaseRepository<Department, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
}

