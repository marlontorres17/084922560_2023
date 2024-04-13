package com.sena.formula.IRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sena.formula.DTO.IEscuderiaDto;
import com.sena.formula.Entity.Escuderia;


@Repository
public interface IEscuderiaRepository extends IBaseRepository<Escuderia, Long>{


		@Query(value = " SELECT  "
				+ " id, "
				+ " concat(nombre,'  ',nacionalidad) as escuderia "
				+ "	FROM  "
				+ "	escuderia "
				+ "	WHERE  "
				+ " deleted_at IS NULL", nativeQuery = true)
		List<IEscuderiaDto> getList();
}