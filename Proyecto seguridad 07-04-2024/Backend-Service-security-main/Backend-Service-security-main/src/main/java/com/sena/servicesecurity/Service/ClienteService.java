package com.sena.servicesecurity.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IClienteDTO;
import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Cliente;
import com.sena.servicesecurity.Entity.Person;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.IClienteRepository;
import com.sena.servicesecurity.IRepository.IPersonRepository;
import com.sena.servicesecurity.IService.IClienteService;
import com.sena.servicesecurity.IService.IPersonService;

import jakarta.persistence.Entity;

@Service
public class ClienteService extends ABaseService<Cliente> implements IClienteService{
	
	@Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
	
	@Autowired
	
	private IClienteRepository repository;
	
	@Autowired
	private IPersonService personService;

	@Autowired
	private IClienteRepository clienteRepository;
	
	
	@Override
	public Cliente savePersonCustomer(Person entity) throws Exception {
	    Person person = personService.save(entity);
	    
        Cliente entityCustomer = new Cliente();
        
	    String codeCustomer = GenerateCodeCliente(person.getId());
	    
	    entityCustomer.setCode(codeCustomer);
	    entityCustomer.setPerson(person);
	    entityCustomer.setState(true);
	    entityCustomer.setCreatedAt(LocalDateTime.now());
	    entityCustomer.setCreatedBy((long) 1);
	    
	    Cliente cliente = save(entityCustomer);
	    
	    return cliente;
	}
	
	
	@Override
	public Cliente save(Cliente entity) throws Exception {
	    try {
	       
    		String codeCustomer = GenerateCodeCliente(entity.getPerson().getId());
	        entity.setCode(codeCustomer);
	        entity.setCreatedAt(LocalDateTime.now());
	        entity.setCreatedBy((long) 1); // Cuando esté el logging, se debe enviar el ID del usuario con Auth
	        return getRepository().save(entity);
	    } catch (Exception e) {
	        // Captura la excepción
	        throw new Exception("Error al guardar la entidad: " + e.getMessage());
	    }
	}
	
	public String GenerateCodeCliente(Long idPerson) throws Exception{
		Optional<Person> person = personService.findById(idPerson);
		
		if(person == null) {
			throw new Exception("Error al consultar la persona: " + idPerson);
		}
		
		String document = person.get().getDocument();
		String numeroDocumento =  document.substring(Math.max(0,document.length()  -4 ));
		String code = LocalDateTime.now().getYear() + "-" + person.get().getTypeDocument() + "-" + numeroDocumento;
		
		return code;
		
	}
	
	public List<IClienteDTO> searchClientData(String term) {
        return clienteRepository.searchClientData(term);
    }

	
	@Override
	protected IBaseRepository<Cliente, Long> getRepository(){
		return repository;
	}
	
	@Override
	public void update(Long id, Cliente entity) throws Exception {
	    Optional<Cliente> op = getRepository().findById(id);

	    if (op.isEmpty()) {
	        throw new Exception("Registro no encontrado");
	    } else if (op.get().getDeletedAt() != null) {
	        throw new Exception("Registro inhabilitado");
	    }

	    Long personId = entity.getPerson().getId();
	    String document = repository.getDocument(personId);
	    String documentType = repository.getDocument(personId); // Obtiene el tipo de documento de la base de datos
	    if (documentType == null) {
	        throw new Exception("No se pudo obtener el tipo de documento para la persona con ID: " + personId);
	    }

	    // Obtener los primeros 4 dígitos del documento
	    String documentDigits = document.substring(0, Math.min(document.length(), 4));

	    // Obtener el año actual
	    int currentYear = LocalDate.now().getYear();

	    // Combinar los elementos para formar el código
	    String code = currentYear + "-" + documentType + "-" + documentDigits;

	    Cliente entityUpdate = op.get();

	    String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
	    BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
	    entityUpdate.setCode(code);
	    entityUpdate.setUpdatedAt(LocalDateTime.now());
	    entityUpdate.setUpdatedBy((long) 1); // Cuando esté el logging, se debe enviar el ID del usuario con Auth
	    getRepository().save(entityUpdate);
	}
}
	


