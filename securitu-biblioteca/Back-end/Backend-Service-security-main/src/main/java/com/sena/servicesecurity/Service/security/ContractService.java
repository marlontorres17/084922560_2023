package com.sena.servicesecurity.Service.security;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IContractDto;
import com.sena.servicesecurity.Entity.Contract;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.security.IContractRepository;
import com.sena.servicesecurity.IService.security.IContractService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class ContractService extends ABaseService<Contract> implements IContractService{

	@Override
	protected IBaseRepository<Contract, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	

	@Autowired
	private IContractRepository repository;
	
	@Override
	public List<IContractDto> GetListContract() {
		// TODO Auto-generated method stub
		return repository.GetListContract();
	}
}
