package com.sena.servicesecurity.Controller.biblioteca;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Registro;
import com.sena.servicesecurity.IService.biblioteca.IRegistroService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/registro")
public class RegistroController extends ABaseController<Registro, IRegistroService>{

	protected RegistroController(IRegistroService service) {
		super(service, "Registro");
		// TODO Auto-generated constructor stub
	}

}