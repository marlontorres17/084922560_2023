package com.sena.servicesecurity.IRepository.security;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Position;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface IPositionRepository extends IBaseRepository<Position, Long>{

}
