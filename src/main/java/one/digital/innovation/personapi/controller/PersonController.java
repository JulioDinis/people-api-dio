package one.digital.innovation.personapi.controller;

import one.digital.innovation.personapi.dto.MessageResponseDTO;
import one.digital.innovation.personapi.entity.Person;
import one.digital.innovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController //controlador rest
@RequestMapping("/api/v1/people") //caminho de acesso principal
public class PersonController {


    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }


    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        Person savedPerson =personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID - "+ savedPerson.getId())
                .build();
    }

}
