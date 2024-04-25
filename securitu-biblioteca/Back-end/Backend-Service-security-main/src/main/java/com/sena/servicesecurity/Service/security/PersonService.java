package com.sena.servicesecurity.Service.security;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Client;
import com.sena.servicesecurity.Entity.Person;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.security.IPersonRepository;
import com.sena.servicesecurity.IService.security.IClientService;
import com.sena.servicesecurity.IService.security.IPersonService;
import com.sena.servicesecurity.Service.ABaseService;

@Service
public class PersonService extends ABaseService<Person> implements IPersonService {

  
    private final IPersonRepository repository;
    
    @Lazy
    private final IClientService clienteService;
    
    public PersonService(IPersonRepository repository, @Lazy IClientService clienteService) {
    	this.repository = repository;
    	this.clienteService = clienteService;
    }
    
    @Override
    protected IBaseRepository<Person, Long> getRepository() {
        return repository;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<IPersonDto> getList() {
        return repository.getList();
    }
    
    
    
    
    public void update(Long id, Person entity) throws Exception {
        Optional<Person> op = getRepository().findById(id);

        if (op.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } else if (op.get().getDeletedAt() != null) {
            throw new Exception("Registro inhabilitado");
        }
        LocalDateTime date = op.get().getCreatedAt();
        Person entityUpdate = op.get();

        String[] ignoreProperties = { "id", "createdAt", "deletedAt", "createdBy", "deletedBy" };
        BeanUtils.copyProperties(entity, entityUpdate, ignoreProperties);
        entityUpdate.setUpdatedAt(LocalDateTime.now());
        entityUpdate.setUpdatedBy((long)1); //Cuanto esté el loggin, se debe enviar el ID del usuario con Auth
        getRepository().save(entityUpdate);
        Optional<Client> opCliente = clienteService.findByPersonId(id);
        
        if (opCliente.isEmpty()) {
            throw new Exception("Registro no encontrado");
        } else if (opCliente.get().getDeletedAt() != null) {
            throw new Exception("Registro inhabilitado");
        }else 
        {
        String code = clienteService.GenerateCodeCustomer(entityUpdate.getTypeDocument(), entity.getTypeDocument(), date);
        
        Client client = opCliente.get();
        client.setCode(code);
        clienteService.update(client.getId(), client);
    }
    
    }

    
    
}