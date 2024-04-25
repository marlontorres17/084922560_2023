package com.sena.servicesecurity.IService.security;

import java.util.List;

import com.sena.servicesecurity.DTO.IModuleDto;
import com.sena.servicesecurity.Entity.Module;
import com.sena.servicesecurity.IService.IBaseService;

public interface IModuleService extends IBaseService<Module>{
	List<IModuleDto> getList();

}
