package com.sena.servicesecurity.Controller.biblioteca;


import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Libro;
import com.sena.servicesecurity.Entity.Persona;
import com.sena.servicesecurity.IService.biblioteca.ILibroService;
import com.sena.servicesecurity.IService.biblioteca.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/persona")
public class PersonaController extends ABaseController<Persona, IPersonaService>{

    protected PersonaController(IPersonaService service) {
		super(service, "Persona");
		// TODO Auto-generated constructor stub
	}

    

    
    

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/{nombrePersona}/libros")
    public List<String> obtenerLibrosPorNombrePersona(@PathVariable String nombrePersona) {
        return personaService.obtenerLibrosPorNombrePersona(nombrePersona);
    }
}
