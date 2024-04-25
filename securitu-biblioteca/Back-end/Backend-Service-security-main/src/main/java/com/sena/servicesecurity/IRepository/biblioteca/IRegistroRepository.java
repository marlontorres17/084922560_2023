package com.sena.servicesecurity.IRepository.biblioteca;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Registro;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IRegistroRepository extends IBaseRepository<Registro, Long>{

}