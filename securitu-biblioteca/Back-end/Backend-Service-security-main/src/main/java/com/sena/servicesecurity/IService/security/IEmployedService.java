package com.sena.servicesecurity.IService.security;

import java.util.List;

import com.sena.servicesecurity.DTO.IEmployedDto;
import com.sena.servicesecurity.Entity.Employed;
import com.sena.servicesecurity.IService.IBaseService;

public interface IEmployedService extends IBaseService<Employed>{

	List<IEmployedDto> getListEmployee();
}
