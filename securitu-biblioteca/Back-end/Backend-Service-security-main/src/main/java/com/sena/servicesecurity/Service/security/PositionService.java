package com.sena.servicesecurity.Service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.Entity.Position;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.security.IPositionRepository;
import com.sena.servicesecurity.IService.security.IPositionService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class PositionService extends ABaseService<Position> implements IPositionService{

	@Override
	protected IBaseRepository<Position, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
	
	@Autowired
	private IPositionRepository repository;

}
