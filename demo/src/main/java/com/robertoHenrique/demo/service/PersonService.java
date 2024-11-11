package com.robertoHenrique.demo.service;


import com.robertoHenrique.demo.entities.Person;
import com.robertoHenrique.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    Logger logger = Logger.getLogger(PersonService.class.getName());

    public PersonService(){}

    public Person Criar(Person person) {
        logger.info("Criando Pessoa "+person.toString());
        return personRepository.save(person);
    }

    public Person atualizar(Integer id,Person person) {
        if (personRepository.existsById(id)) {
        Person p = new Person();
        p.setId(id);
        p.setName(person.getName());
        p.setAge(person.getAge());
        p.setEmail(person.getEmail());
        return personRepository.save(p);
        } else {
            return null;
        }
    }

    public List<Person> listarTodos() {
        if (personRepository.count() == 0) {
            logger.info("Não existe pessoas cadastradas");
        }
        return personRepository.findAll();
    }

    public Person buscarPorId(Integer id) {
        if(personRepository.existsById(id)) {
            logger.info("Buscando Pessoa " + id);
            return personRepository.findById(id).get();
        }
        logger.info("Não existe Pessoa com o ID " + id);
        return null;
    }

    public void remover(Integer id) {
        if(personRepository.existsById(id)) {
            logger.info("Removendo Pessoa " + id);
            personRepository.deleteById(id);
            logger.info("Pessoa removida com sucesso");
        }else {
            logger.info("Nao existe Pessoa " + id);
        }
    }

}
