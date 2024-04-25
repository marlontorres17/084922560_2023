package com.sena.servicesecurity.IService.security;

import java.util.List;

import com.sena.servicesecurity.DTO.IViewDto;
import com.sena.servicesecurity.Entity.View;
import com.sena.servicesecurity.IService.IBaseService;

public interface IViewService extends IBaseService<View>{
	List<IViewDto> getList();
}
