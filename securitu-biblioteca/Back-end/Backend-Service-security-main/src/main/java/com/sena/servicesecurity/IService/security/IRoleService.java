package com.sena.servicesecurity.IService.security;

import java.util.List;

import com.sena.servicesecurity.DTO.IRoleDto;
import com.sena.servicesecurity.Entity.Role;
import com.sena.servicesecurity.IService.IBaseService;

public interface IRoleService extends IBaseService<Role>{

	List<IRoleDto> getList();
}
