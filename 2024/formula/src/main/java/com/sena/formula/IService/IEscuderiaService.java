package com.sena.formula.IService;

import java.util.List;

import com.sena.formula.DTO.IEscuderiaDto;
import com.sena.formula.Entity.Escuderia;

public interface IEscuderiaService extends IBaseService<Escuderia>{
	
	List<IEscuderiaDto> getList();

}