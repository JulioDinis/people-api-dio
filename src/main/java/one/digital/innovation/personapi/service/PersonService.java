package one.digital.innovation.personapi.service;

import one.digital.innovation.personapi.dto.MessageResponseDTO;
import one.digital.innovation.personapi.dto.request.PersonDTO;
import one.digital.innovation.personapi.entity.Person;
import one.digital.innovation.personapi.exception.PersonNotFoundExeption;
import one.digital.innovation.personapi.mapper.PersonMapper;
import one.digital.innovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {


    private PersonRepository personRepository;


    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person personToSave = personMapper.toModel(personDTO);
        personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID - " + personToSave.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        return personRepository.findAll().stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundExeption {
//        Optional<Person> optionalPerson = personRepository.findById(id);
//        if (optionalPerson.isEmpty()) {
//            throw new PersonNotFoundExeption(id);
//        }
       Person person  = verifyIfExists(id);

        return personMapper.toDTO(person);
    }

    public void deleteById(Long id) throws PersonNotFoundExeption {
        Person person  = verifyIfExists(id);
        personRepository.deleteById(id);

    }

    private Person verifyIfExists(Long id) throws PersonNotFoundExeption {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundExeption(id));
    }
}
