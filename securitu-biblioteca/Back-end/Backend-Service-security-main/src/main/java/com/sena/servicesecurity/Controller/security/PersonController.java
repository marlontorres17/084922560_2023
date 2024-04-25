package com.sena.servicesecurity.Controller.security;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.DTO.ApiResponseDto;
import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Person;
import com.sena.servicesecurity.IService.security.IPersonService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/person")
public class PersonController extends ABaseController<Person,IPersonService>{
	public PersonController(IPersonService service) {
        super(service, "Person");
        
    }
	@GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<IPersonDto>>> show() {
        try {
            List<IPersonDto> entity = service.getList();
            return ResponseEntity.ok(new ApiResponseDto<List<IPersonDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IPersonDto>>(e.getMessage(), null, false));
        }
		}
	
	/*@PutMapping("/updateAC/{id}")
    public ResponseEntity<ApiResponseDto<Person>> updateAC(@PathVariable Long id, @RequestBody Person entity) {
        try {
            service.updateAC(id, entity);
            return ResponseEntity.ok(new ApiResponseDto<Person>("Datos actualizados", null, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Person>(e.getMessage(), null, false));
        }
        */
    }

