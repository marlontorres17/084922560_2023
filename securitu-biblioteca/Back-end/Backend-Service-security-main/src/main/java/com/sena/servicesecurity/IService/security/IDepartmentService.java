package com.sena.servicesecurity.IService.security;

import java.util.List;

import com.sena.servicesecurity.DTO.IDepartmentDto;
import com.sena.servicesecurity.Entity.Department;
import com.sena.servicesecurity.IService.IBaseService;

public interface IDepartmentService extends IBaseService<Department> {
	 List<IDepartmentDto> getListDepartaments();
}
