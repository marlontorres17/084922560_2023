package com.sena.servicesecurity.Controller.security;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.servicesecurity.Controller.ABaseController;
import com.sena.servicesecurity.Entity.Company;
import com.sena.servicesecurity.IService.security.ICompanyService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/company")
public class CompanyController extends ABaseController<Company,ICompanyService>{

	protected CompanyController(ICompanyService service) {
		super(service, "Company");
		// TODO Auto-generated constructor stub
	}

}
