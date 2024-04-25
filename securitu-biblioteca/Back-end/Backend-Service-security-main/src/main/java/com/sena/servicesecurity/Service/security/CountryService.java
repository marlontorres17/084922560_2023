package com.sena.servicesecurity.Service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.ICountryDto;
import com.sena.servicesecurity.Entity.Country;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.security.ICountryRepository;
import com.sena.servicesecurity.IService.security.ICountryService;
import com.sena.servicesecurity.Service.ABaseService;
@Service
public class CountryService extends ABaseService<Country> implements ICountryService{


	
	@Autowired
	public ICountryRepository repository;

	@Override
	protected IBaseRepository<Country, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	

	@Override
	public List<ICountryDto> getListCountrys() {
		// TODO Auto-generated method stub
		return repository.getListCountrys();
	}
	
	

}