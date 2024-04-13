package com.sena.servicesecurity.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.servicesecurity.DTO.IPersonDto;
import com.sena.servicesecurity.Entity.Cliente;
import com.sena.servicesecurity.Entity.Person;
import com.sena.servicesecurity.IRepository.IBaseRepository;
import com.sena.servicesecurity.IRepository.IPersonRepository;
import com.sena.servicesecurity.IService.IPersonService;

@Service
public class PersonService extends ABaseService<Person> implements IPersonService {

    @Autowired
    private IPersonRepository repository;
    


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
    
    
}