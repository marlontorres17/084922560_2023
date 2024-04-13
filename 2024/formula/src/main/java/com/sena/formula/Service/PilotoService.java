package com.sena.formula.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.formula.DTO.IPilotoDto;
import com.sena.formula.Entity.Piloto;
import com.sena.formula.IRepository.IBaseRepository;
import com.sena.formula.IRepository.IPilotoRepository;
import com.sena.formula.IService.IPilotoService;


@Service
public class PilotoService extends ABaseService<Piloto> implements IPilotoService{
	@Override
	protected IBaseRepository<Piloto, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IPilotoRepository repository;

	@Override
	public List<IPilotoDto> getList() {
		
		return repository.getList();
	}
	
	
}