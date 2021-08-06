package edu.spring.rest;

import edu.spring.domain.Person;
import edu.spring.repostory.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private final PersonRepository repository;

    public PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/person")
    public List<PersonDto> get() {
        return repository.findAll().stream()
            .map(PersonDto::toDto)
            .collect(Collectors.toList());
    }

    @GetMapping("/person/{id}")
    public PersonDto get(@PathVariable("id") int id) {
        Person person = repository.findById(id)
            .orElseThrow(NotFoundException::new);
        return PersonDto.toDto(person);
    }

    // @ResponseBody включён в @RestController
    @PostMapping("/person")
    public PersonDto create(@RequestBody PersonDto dto) {
        Person account = PersonDto.toDomainObject(dto);
        Person accountWithId = repository.save(account);
        return PersonDto.toDto(accountWithId);
    }

    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable("id") int id) {
        repository.deleteById(id);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotEnoughFunds(NotFoundException ex) {
        return ResponseEntity.badRequest().body("Not found");
    }
}
