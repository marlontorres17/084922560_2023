package com.sena.servicesecurity.IRepository.security;

import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.Entity.Company;
import com.sena.servicesecurity.IRepository.IBaseRepository;

@Repository
public interface ICompanyRepository extends IBaseRepository<Company, Long>{

}
