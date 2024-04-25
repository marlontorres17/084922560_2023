package com.sena.servicesecurity.Service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IViewDto;
import com.sena.servicesecurity.Entity.View;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.security.IViewRepository;
import com.sena.servicesecurity.IService.security.IViewService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class ViewService extends ABaseService<View> implements IViewService{

	@Override
	protected IBaseRepository<View, Long> getRepository() {
		return repository;
	}
	
	@Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
	
	
	@Autowired
	private IViewRepository repository;

	@Override
	public List<IViewDto> getList() {
		return repository.getList();
	}
	
	
}