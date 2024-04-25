package com.sena.servicesecurity.Controller.biblioteca;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Autor;
import com.sena.servicesecurity.IService.biblioteca.IAutorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/autor")
public class AutorController extends ABaseController<Autor, IAutorService>{

	protected AutorController(IAutorService service) {
		super(service, "Autor");
		// TODO Auto-generated constructor stub
	}

}
