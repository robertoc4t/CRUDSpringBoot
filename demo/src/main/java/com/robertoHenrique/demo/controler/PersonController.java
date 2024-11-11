package com.robertoHenrique.demo.controler;

import com.robertoHenrique.demo.entities.Person;
import com.robertoHenrique.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired

    PersonService personService;

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person criar(@RequestBody Person person) {
        return personService.Criar(person);
    }

    @PostMapping(value = "/{id}")
    public Person atualizar( @PathVariable (value = "id")Integer id,@RequestBody Person person) {
        return personService.atualizar(id, person);
    }

    @GetMapping
    public List<Person> listar() {
        return personService.listarTodos();
    }

    @GetMapping("/{id}")
    public Person buscarPorId(@PathVariable Integer id) {
        return personService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        personService.remover(id);
    }
}
