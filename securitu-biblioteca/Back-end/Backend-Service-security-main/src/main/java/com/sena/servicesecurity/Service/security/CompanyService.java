package com.sena.servicesecurity.Service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Company;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.security.ICompanyRepository;
import com.sena.servicesecurity.IService.security.ICompanyService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class CompanyService extends ABaseService<Company> implements ICompanyService{

	@Override
	protected IBaseRepository<Company, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	
	@Autowired
	private ICompanyRepository repository;

}
