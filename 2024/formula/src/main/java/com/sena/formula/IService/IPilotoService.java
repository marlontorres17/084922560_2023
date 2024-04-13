package com.sena.formula.IService;

import java.util.List;

import com.sena.formula.DTO.IPilotoDto;
import com.sena.formula.Entity.Piloto;

public interface IPilotoService extends IBaseService<Piloto>{
	
	List<IPilotoDto> getList();

}