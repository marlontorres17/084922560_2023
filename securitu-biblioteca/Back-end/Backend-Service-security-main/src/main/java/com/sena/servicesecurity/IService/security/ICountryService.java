package com.sena.servicesecurity.IService.security;

import java.util.List;

import com.sena.servicesecurity.DTO.ICountryDto;
import com.sena.servicesecurity.Entity.Country;
import com.sena.servicesecurity.IService.IBaseService;

public interface ICountryService  extends IBaseService<Country>{
	List<ICountryDto> getListCountrys();
}
