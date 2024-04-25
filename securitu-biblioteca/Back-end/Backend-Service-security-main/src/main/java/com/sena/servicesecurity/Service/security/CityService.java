package com.sena.servicesecurity.Service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.ICityDto;
import com.sena.servicesecurity.Entity.City;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.security.ICityRepository;
import com.sena.servicesecurity.IService.security.ICityService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class CityService extends ABaseService<City> implements ICityService{

	@Override
	protected IBaseRepository<City, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Autowired
	public ICityRepository repository;

	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Override
	public List<ICityDto> GetListCitys() {
		// TODO Auto-generated method stub
		return repository.GetListCitys();
	}

}
