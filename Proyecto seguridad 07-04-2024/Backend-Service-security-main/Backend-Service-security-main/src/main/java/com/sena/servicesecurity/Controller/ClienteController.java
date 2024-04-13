package com.sena.servicesecurity.Controller;

import java.util.List;
import com.sena.servicesecurity.Entity.Person;
import com.sena.servicesecurity.IService.IClienteService;
import com.sena.servicesecurity.Entity.Cliente;
import com.sena.servicesecurity.Controller.ABaseController;
import org.springframework.web.bind.annotation.RequestBody;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.IClienteDTO;
import com.sena.servicesecurity.Entity.Cliente;
import com.sena.servicesecurity.Entity.Person;
import com.sena.servicesecurity.IService.IClienteService;
import com.sena.servicesecurity.Service.ClienteService;
import com.sena.servicesecurity.Entity.Cliente;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/cliente")
public class ClienteController extends ABaseController<Cliente, IClienteService>{
	

	protected ClienteController(IClienteService service) {
		super(service, "Cliente");
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Autowired
    private IClienteService clienteService;
	
	@GetMapping("/data")
    public ResponseEntity<?> searchClientData(@RequestParam("term") String term) {
        List<IClienteDTO> clientData = clienteService.searchClientData(term);
        return ResponseEntity.ok().body(clientData);
    }
	
	
	@PostMapping("/personCliente")
	public ResponseEntity<ApiResponseDto<Cliente>> save(@RequestBody Person entity) {
        try {
        	System.out.println(entity);
            return ResponseEntity.ok(new ApiResponseDto<Cliente>("Datos guardados", service.savePersonCustomer(entity), true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Cliente>(e.getMessage(), null, false));
        }
    }
    }
	


