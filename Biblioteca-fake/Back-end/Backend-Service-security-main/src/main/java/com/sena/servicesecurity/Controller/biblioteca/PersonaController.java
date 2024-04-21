package com.sena.servicesecurity.Controller.biblioteca;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Persona;
import com.sena.servicesecurity.IService.biblioteca.IPersonaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/persona")
public class PersonaController extends ABaseController<Persona, IPersonaService>{

	protected PersonaController(IPersonaService service) {
		super(service, "Persona");
		// TODO Auto-generated constructor stub
	}

}
