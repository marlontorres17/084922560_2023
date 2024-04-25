package com.sena.servicesecurity.IRepository.security;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Person;
import com.sena.servicesecurity.IRepository.IBaseRepository;


@Repository
public interface IPersonRepository extends IBaseRepository<Person, Long>{


		@Query(value = " SELECT  "
				+ " id, "
				+ " concat(first_name,'  ',last_name) as person "
				+ "	FROM  "
				+ "	person "
				+ "	WHERE  "
				+ " deleted_at IS NULL", nativeQuery = true)
		List<IPersonDto> getList();
		
		
		
		
}
