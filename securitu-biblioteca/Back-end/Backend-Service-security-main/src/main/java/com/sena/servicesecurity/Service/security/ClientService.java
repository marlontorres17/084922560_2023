package com.sena.servicesecurity.Service.security;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IClientDto;
import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Client;
import com.sena.servicesecurity.Entity.Person;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.security.IClientRepository;
import com.sena.servicesecurity.IService.security.IClientService;
import com.sena.servicesecurity.IService.security.IPersonService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class ClientService extends ABaseService<Client> implements IClientService{

	private IClientRepository repository;
	
	@Lazy
	private IPersonService personService;
	
	public ClientService(@Lazy IPersonService personService, IClientRepository repository) {
		this.personService = personService;
		this.repository = repository;
	}
	
	@Override
	public void delete(Long id) {
	    repository.deleteById(id);
	}
	
	@Override
	protected IBaseRepository<Client, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

	@Override
	public List<IClientDto> getList() {
		return repository.getList();
	}

	@Override
	public Client save(Client entity) throws Exception {
		try {
			 IPersonDto person = repository.getDocument(entity.getPerson().getId());
		        
		        
		       String type = person.getType_document();
		       String document = person.getDocument();
		       int currentYear = LocalDateTime.now().getYear();
		       String currentSuffix = document.substring(Math.max(0, document.length() -4));
		       
		       String code = currentYear + "-" + type + "-" + currentSuffix;
		        
		       
		        entity.setCode(code);
		        entity.setCreatedAt(LocalDateTime.now());
		        entity.setCreatedBy((long) 1); // Cuando esté el logging, se debe enviar el ID del usuario con Auth
		        return getRepository().save(entity);
		    } catch (Exception e) {
		        // Captura la excepción
		        throw new Exception("Error al guardar la entidad: " + e.getMessage());
		    }
	}

	@Override
	public void update(Long id, Client entity) throws Exception {
		Optional<Client> opClient = getRepository().findById(id);

        if (opClient.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } else if (opClient.get().getDeletedAt() != null) {
            throw new Exception("Registro inhabilitado");
        }
        
        	
        Person personUpdate = entity.getPerson();
 
        Client existingClient = opClient.get();
        Person PersonExist = existingClient.getPerson();
        // Verificar si el documento ha cambiado
        if (PersonExist.getDocument() != entity.getPerson().getDocument() || PersonExist.getTypeDocument() != entity.getPerson().getTypeDocument()) {
            // El documento ha cambiado, genera un nuevo código
 
        	String newCode = GenerateCodeCustomer(personUpdate.getTypeDocument(), personUpdate.getDocument(), opClient.get().getCreatedAt());
            existingClient.setCode(newCode);
        }
        
      
        personService.update(personUpdate.getId(), personUpdate);
        String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy", "code" };
        BeanUtils.copyProperties(entity, existingClient, ignoreProperties);
        existingClient.setUpdatedAt(LocalDateTime.now());
        existingClient.setUpdatedBy((long)1); 
        getRepository().save(existingClient);
    }

	@Override
	public String GenerateCodeCustomer(String typeDocument, String document, LocalDateTime date) 
			throws Exception {
			 	String documentDigit= document.substring(Math.max(0, document.length() -4));
			 	String code= date.getYear()+"-"+typeDocument+"-"+documentDigit;
				return code;
	}

	@Override
	public Client savePersonClient(Person entity) throws Exception {
		Person person = personService.save(entity);
		System.out.println(person.getTypeDocument());
		Client entityClient = new Client();
		String codeClient =  GenerateCodeCustomer(person.getTypeDocument(), person.getDocument(), person.getCreatedAt());
		System.out.println(codeClient);
		entityClient.setCode(codeClient);        
		entityClient.setPerson(person); 
		entityClient.setState(true); 
		entityClient.setCreatedAt(LocalDateTime.now());
		entityClient.setCreatedBy((long)1);
		Client client = repository.save(entityClient);
		return client;
		
	}

	@Override
	public Optional<Client>  findByPersonId(long personId) {
		// TODO Auto-generated method stub
		return repository.findByPersonId(personId);
	}
}
