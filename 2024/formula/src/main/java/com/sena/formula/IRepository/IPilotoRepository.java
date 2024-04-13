package com.sena.formula.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.formula.DTO.IPilotoDto;
import com.sena.formula.Entity.Piloto;


@Repository
public interface IPilotoRepository extends IBaseRepository<Piloto, Long>{


		@Query(value = " SELECT  "
				+ " id, "
				+ " concat(nombre,'  ',apellido) as piloto "
				+ "	FROM  "
				+ "	piloto "
				+ "	WHERE  "
				+ " deleted_at IS NULL", nativeQuery = true)
		List<IPilotoDto> getList();
}