package one.digital.innovation.personapi.controller;

import one.digital.innovation.personapi.dto.MessageResponseDTO;
import one.digital.innovation.personapi.dto.request.PersonDTO;
import one.digital.innovation.personapi.entity.Person;
import one.digital.innovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController //controlador rest
@RequestMapping("/api/v1/people") //caminho de acesso principal
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

}
