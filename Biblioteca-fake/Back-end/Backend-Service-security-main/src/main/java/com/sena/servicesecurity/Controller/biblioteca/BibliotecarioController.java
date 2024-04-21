package com.sena.servicesecurity.Controller.biblioteca;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Bibliotecario;
import com.sena.servicesecurity.IService.biblioteca.IBibliotecarioService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/bibliotecario")
public class BibliotecarioController extends ABaseController<Bibliotecario, IBibliotecarioService>{

	protected BibliotecarioController(IBibliotecarioService service) {
		super(service, "Bibliotecario");
		// TODO Auto-generated constructor stub
	}

}
