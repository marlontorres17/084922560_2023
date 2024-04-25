package com.sena.servicesecurity.IService.security;

import java.util.List;

import com.sena.servicesecurity.DTO.ICityDto;
import com.sena.servicesecurity.Entity.City;
import com.sena.servicesecurity.IService.IBaseService;

public interface ICityService extends IBaseService<City> {
	List<ICityDto> GetListCitys();
}
