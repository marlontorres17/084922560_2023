package com.sena.formula.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.formula.DTO.IEscuderiaDto;
import com.sena.formula.Entity.Escuderia;
import com.sena.formula.IRepository.IBaseRepository;
import com.sena.formula.IRepository.IEscuderiaRepository;
import com.sena.formula.IService.IEscuderiaService;


@Service
public class EscuderiaService extends ABaseService<Escuderia> implements IEscuderiaService{
	@Override
	protected IBaseRepository<Escuderia, Long> getRepository() {
		return repository;
	}
	
	@Autowired
	private IEscuderiaRepository repository;

	@Override
	public List<IEscuderiaDto> getList() {
		
		return repository.getList();
	}
	
	
}