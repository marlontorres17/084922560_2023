package com.sena.formula.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.formula.DTO.ApiResponseDto;
import com.sena.formula.DTO.IEscuderiaDto;
import com.sena.formula.Entity.Escuderia;
import com.sena.formula.IService.IEscuderiaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/escuderia")
public class EscuderiaController extends ABaseController<Escuderia,IEscuderiaService>{
	public EscuderiaController(IEscuderiaService service) {
        super(service, "Escuderia");
        
    }
	@GetMapping("/list")
    public ResponseEntity<ApiResponseDto<List<IEscuderiaDto>>> show() {
        try {
            List<IEscuderiaDto> entity = service.getList();
            return ResponseEntity.ok(new ApiResponseDto<List<IEscuderiaDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<IEscuderiaDto>>(e.getMessage(), null, false));
        }
		}
	}