package com.sena.servicesecurity.IService.security;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.sena.servicesecurity.DTO.IUserDto;
import com.sena.servicesecurity.DTO.IViewDto;
import com.sena.servicesecurity.Entity.User;
import com.sena.servicesecurity.IService.IBaseService;

public interface IUserService extends IBaseService<User>{

	 Optional<IUserDto> getUserWithViews(String username, String password);
	 
	 

}
