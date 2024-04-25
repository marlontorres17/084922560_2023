package com.sena.servicesecurity.IService.security;

import java.util.List;

import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Person;
import com.sena.servicesecurity.IService.IBaseService;

public interface IPersonService extends IBaseService<Person>{
	
	List<IPersonDto> getList();
	//void updateAC(Long id, Person entity) throws Exception;
	
}
