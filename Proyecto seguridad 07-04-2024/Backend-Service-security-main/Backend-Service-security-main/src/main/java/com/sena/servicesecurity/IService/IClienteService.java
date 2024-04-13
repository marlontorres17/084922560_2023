package com.sena.servicesecurity.IService;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IClienteDTO;
import com.sena.servicesecurity.Entity.Cliente;
import com.sena.servicesecurity.Entity.Person;

@Repository
public interface IClienteService extends IBaseService<Cliente>{
	/* List<IClienteDTO> getAllWithCode();
	List<Cliente> getAll();*/
	
	List<IClienteDTO> searchClientData(String term);
	public String GenerateCodeCliente(Long idPerson) throws Exception;
	public Cliente savePersonCustomer(Person entity) throws Exception;
	
}
