package com.sena.servicesecurity.Controller.biblioteca;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Lector;
import com.sena.servicesecurity.IService.biblioteca.ILectorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/lector")
public class LectorController extends ABaseController<Lector, ILectorService>{

	protected LectorController(ILectorService service) {
		super(service, "Lector");
		// TODO Auto-generated constructor stub
	}

}
