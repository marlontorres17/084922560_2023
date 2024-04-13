package com.sena.formula.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.formula.DTO.ApiResponseDto;
import com.sena.formula.DTO.IPilotoDto;
import com.sena.formula.Entity.Piloto;
import com.sena.formula.IService.IPilotoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/piloto")
public class PilotoController extends ABaseController<Piloto,IPilotoService>{
	public PilotoController(IPilotoService service) {
        super(service, "Piloto");
        
    }
	@GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<IPilotoDto>>> show() {
        try {
            List<IPilotoDto> entity = service.getList();
            return ResponseEntity.ok(new ApiResponseDto<List<IPilotoDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IPilotoDto>>(e.getMessage(), null, false));
        }
		}
	}